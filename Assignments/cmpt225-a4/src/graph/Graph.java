package graph;

import java.util.*;

public class Graph {
    private final int verticesCount;
    private int edgesCount;
    private final List<Set<Integer>> adjVerticesList; // List that holds unique adjacent vertices

    /**
     * creates an empty graph on n nodes
     * the "names" of the vertices are 0,1,...,n-1
     * @param n - number of vertices in the graph
     */
    public Graph(int n) {
        this.verticesCount = n;
        this.adjVerticesList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjVerticesList.add(new HashSet<>());
        }
        this.edgesCount = 0; // Possible to have a graph of n vertices, while none are connected
    }


    /**
     * adds the edge (i,j) to the graph
     * no effect if i and j were already adjacent
     *
     * @param i, j - vertices in the graph
     */
    public void addEdge(int i, int j) {
        // Validate Parameters
        if(i < 0 || j < 0 || i == j){ return; }
        if(i >= numberOfVertices() || j >= numberOfVertices()){ return; }

        // Check if they already have pre-existing edge
        if(!adjVerticesList.get(i).contains(j) || !adjVerticesList.get(j).contains(i)){
            adjVerticesList.get(i).add(j);
            adjVerticesList.get(j).add(i);
            edgesCount++;
        }
    }

    /**
     * removes the edge (i,j) from the graph
     * no effect if i and j were not adjacent
     *
     * @param i, j - vertices in the graph
     */
    public void removeEdge(int i, int j) {
        // Parameter Validation
        if(i < 0 || j < 0 || i == j){ return; }
        if(i >= numberOfVertices() || j >= numberOfVertices()){ return; }

        // Check that they were actually adjacent
        if(adjVerticesList.get(i).contains(j) || adjVerticesList.get(j).contains(i)){
            adjVerticesList.get(i).remove(j);
            adjVerticesList.get(j).remove(i);
            edgesCount--;
        }
    }

    /**
     * @param i, j - vertices in the graph
     * @return true if (i,j) is an edge in the graph, and false otherwise
     */
    public boolean areAdjacent(int i, int j) {
        if(i < 0 || j < 0 || j == i){ return false; }
        if(i >= numberOfVertices() || j >= numberOfVertices()){ return false; }

        return adjVerticesList.get(i).contains(j) && adjVerticesList.get(j).contains(i);
    }

    /**
     * @param i - a vertex in the graph
     * @return the degree of i
     */
    public int degree(int i) {
        // Verify parameters
        if(i < 0 || i >= numberOfVertices()){
            return -1;
        }
        return adjVerticesList.get(i).size();
    }

    /**
     * The iterator must output the neighbors of i in the increasing order
     * Assumption: the graph is not modified during the use of the iterator
     *
     * @param i - a vertex in the graph
     * @return an iterator that returns the neighbors of i
     */
    public Iterator<Integer> neighboursIterator(int i) {
        // Verify parameters
        if(i < 0 || i >= numberOfVertices()){
            return null;
        }

        Set<Integer> adjacentVertices = adjVerticesList.get(i);
        if(adjacentVertices == null){
            return null;
        }

        // Sort our data
        Integer[] neighbours = adjacentVertices.toArray(new Integer[0]);
        bubbleSort(neighbours);
        return Arrays.stream(neighbours).iterator();
    }

    /**
     * @return number of vertices in the graph
     */
    public int numberOfVertices() {
        return this.verticesCount;
    }

    /**
     * @return number of edges in the graph
     */
    public int numberOfEdges() {
        return this.edgesCount;
    }

    /**
     * @param i, j - vertices in the graph
     * @return distance between the vertices
     */
    public int distance(int i, int j) {
        if(i == j){ return 0; } // Same vertice
        if(i < 0 || j < 0 || i >= numberOfVertices() || j >= numberOfVertices()){ return -1; }

        // Are adjacent
        if(adjVerticesList.get(i).contains(j)){
            return 1;
        }

        boolean[] isVisited = new boolean[numberOfVertices()];
        int[] distance = new int[numberOfVertices()];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        distance[i] = 0; // Distance to itself is 0
        isVisited[i] = true;

        while(!queue.isEmpty()){
             int cur = queue.poll();

             // Check adjacent vertices
            for(int neighbour: adjVerticesList.get(cur)){
                if(!isVisited[neighbour]){
                    isVisited[neighbour] = true; // Mark as visited
                    distance[neighbour] = distance[cur] + 1;
                    queue.offer(neighbour); // Add to queue

                    // CHeck if indexes our matching
                    if(neighbour == j){
                        return distance[neighbour];
                    }
                }
            }
        }

        return -1;
    }

    /**
     * @param n - number of vertices
     * @param p - number between 0 and 1
     * @return a random graph on n vertices, where each edge is added to the graph with probability p
     */
    public static Graph generateRandomGraph(int n, double p) {
        Graph graph = new Graph(n);
        Random random = new Random();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(random.nextDouble() < p){
                    graph.addEdge(i, j);
                }
            }
        }
        return graph;
    }

    private void bubbleSort(Integer[] arr){
        int size = arr.length;
        for(int i = 0; i < size - 1; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

}
