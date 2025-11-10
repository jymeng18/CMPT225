import java.util.Arrays;
import java.util.Iterator;

import graph.Graph;

public class TestGraph {

	public static Graph createGraph() {
		//
		//    ---- 0 ----
		//   |     |     |
		//   1 --- 2 --- 3
		//   |   / | \   |
		//   | /   |   \ |
		//   4 --- 5 --- 6 -- 7
		//
		Graph graph = new Graph(8);
		graph.addEdge(0,1);
		graph.addEdge(0,2);
		graph.addEdge(0,3);
		graph.addEdge(1,2);
		graph.addEdge(1,4);
		graph.addEdge(2,3);
		graph.addEdge(2,4);
		graph.addEdge(2,5);
		graph.addEdge(2,6);
		graph.addEdge(3,6);
		graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,7);

		if (graph.areAdjacent(6, 3))
			System.out.println("test create 1 ok");
		else
			System.out.println("test create 1 fail");

		graph.addEdge(1,6);

		if (graph.areAdjacent(1, 6) == true)
			System.out.println("test create 2 ok");
		else
			System.out.println("test create 2 fail");

		graph.removeEdge(1,6);
		if (graph.areAdjacent(1, 6) == false)
			System.out.println("test create 3 ok");
		else
			System.out.println("test create 3 fail");

		return graph;
	}

	public static void testDistance(Graph graph) {
		if (graph.distance(0,5)==2)
			System.out.println("testDistance(0,5) ok");
		else
			System.out.println("testDistance(0,5) fail");

		if (graph.distance(4,5)==1)
			System.out.println("testDistance(4,5) ok");
		else
			System.out.println("testDistance(4,5) fail");

        if (graph.distance(7,0)==3)
            System.out.println("testDistance(7,0) ok");
        else
            System.out.println("testDistance(7,0) fail");

    }


	public static void testIterator(Graph graph) {
		Iterator<Integer> it = graph.neighboursIterator(3);
		if (it!= null && 
				it.hasNext() && it.next()==0 &&
				it.hasNext() && it.next()==2 &&
				it.hasNext() && it.next()==6 &&
				!it.hasNext()) 
			System.out.println("testIterator 3 ok");
		else
			System.out.println("testIterator 3 fail");
	}


	public static void testRadnomGraph() {
		int n = 100;
		Graph randomGraph = Graph.generateRandomGraph(100, 0.5);
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				max = Math.max(max, randomGraph.distance(i, j));
			}
		}
		if (max == 2)
			System.out.println("testRadnomGraph 1 ok");
		else
			System.out.println("testRadnomGraph 1 either wrong or unlucky");

		if (randomGraph.degree(1) > 35 && randomGraph.degree(1) < 65)
			System.out.println("testRadnomGraph 2 ok");
		else
			System.out.println("testRadnomGraph 2 either wrong or unlucky");

		if (randomGraph.numberOfEdges() > 1500 && randomGraph.numberOfEdges() < 3500)
			System.out.println("testRadnomGraph 3 ok");
		else
			System.out.println("testRadnomGraph 3 either wrong or unlucky");
	}



	public static void main(String[] args) {
		Graph graph = createGraph();
		testDistance(graph);
		testIterator(graph);
		testRadnomGraph();
	}
}
