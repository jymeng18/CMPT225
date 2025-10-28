package graph;

import java.util.*;

public class Graph<T> {

	// an interface supporting the operations add, remove, contains
	// Three standard implementations are: HashSet, TreeSet, LinkedHashSet
	// HashSet implements all operations in O(1) **usually**
	// TreeSet implements all operations in O(log(n)) always: uses Red-Black Trees
	// LinkedHashSet implements all operations in O(1) **usually** 
	private Set<Vertex<T>> vertices;
	
	// The data structure is also called Dictionary (but the class is obsolete in Java)
	// Has pairs of objects <Key, Value>
	// The interface supports the operations add, remove, contains
	// Three most useful operations are: add a pair, find by Key, remove by Key
	// The standard implementations are: HashMap, TreeMap, LinkedHashSet
	// here Key is a vertex and Value - set of neighbors
	private Map<Vertex<T>, Set<Vertex<T>>> edges;

	public Graph() {
		vertices = new HashSet<Vertex<T>>();
		edges = new HashMap<Vertex<T>, Set<Vertex<T>>>();
	}


	public Set<Vertex<T>> getVertices() {
		return vertices;
	}

	public Vertex<T> getVertexByName(T name) {
		for (Vertex<T> v : vertices)
			if (v.getName().equals(name))
				return v;

		return null;
	}


	public Set<Vertex<T>> getNeighbours(Vertex<T> v) {
		return edges.get(v);
	}


	/** 
	 * returns false if the vertex with this name was already in the graph
	 * @param name
	 * @return
	 */
	public boolean addVertex(Vertex<T> v) {
		boolean newNode = vertices.add(v);
		if (newNode)
			edges.put(v, new HashSet<Vertex<T>>());
		return newNode;
	}

	/** 
	 * add vertex with a given name
	 * returns false if the vertex with this name was already in the graph
	 * @param name
	 * @return
	 */
	public boolean addVertex(T name) {
		return addVertex(new Vertex<T>(name));
	}

	/** 
	 * returns true if the edge is new to this graph
	 * assume both u and v are already vertices in the graph
	 * @param v
	 * @param u
	 * @return
	 */
	public boolean addEdge(Vertex<T> v, Vertex<T> u) {
		if (edges.get(v).contains(u) || edges.get(u).contains(v))
            return false;
        else
			return (edges.get(v).add(u) && edges.get(u).add(v));
	}


	/** 
	 * add edge by names of the vertices
	 * returns true if the edge is new to this graph
	 * assume both u and v are already vertices in the graph
	 * @param v
	 * @param u
	 * @return
	 */
	public boolean addEdge(T v, T u) {
		return addEdge(getVertexByName(v), getVertexByName(u));
	}

	public boolean removeEdge(Vertex<T> v, Vertex<T> u) {
		if (vertices.contains(v) && vertices.contains(u))
			return (edges.get(v).remove(u) && edges.get(u).remove(v)); 
		else
			return false;
	}
	
	private void setAllUnvisited() {
		for (Vertex<T> v : vertices) {
			v.setVisited(false);
			v.setParent(null);
		}
	}


	public void printPath(Vertex<T> target) {
		Stack<Vertex<T>> s = new Stack<Vertex<T>>();
		while (target!=null) {
			s.push(target);
			target = target.getParent();
		}
		
		System.out.print(s.pop().getName());
		while (!s.isEmpty()) {
			System.out.print(" -> " + s.pop().getName());
		}
		System.out.println();
	}


	/**
	 * runs a BFS traversal
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public void BreadthFirstSearch(Vertex<T> source) {
		setAllUnvisited();
		LinkedList<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		queue.addLast(source);
		source.setVisited(true);

		while (!queue.isEmpty()) {
			Vertex<T> v = queue.removeFirst();
			System.out.print(v.getName() + " ");
			Set<Vertex<T>> Nv = getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					queue.addLast(u);
					u.setVisited(true);
					u.setParent(v);
				}
			}  
		}
	}

	/**
	 * runs a DFS traversal with u.setVisited(true) when vertex added to the stack
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public void DepthFirstSearch1(Vertex<T> source) {
		setAllUnvisited();

		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(source);
		source.setVisited(true);

		while (!stack.isEmpty()) {
			Vertex<T> v = stack.pop();
			System.out.print(v.getName() + " ");
			Set<Vertex<T>> Nv = getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					stack.push(u);
					u.setVisited(true);
					u.setParent(v);
				}
			}  
		}
	}

	/**
	 * runs a DFS traversal with u.setVisited(true) when vertex is removed from the stack
	 * 
	 * @param <T>
	 * @param G - graph
	 * @param source - starting vertex. Assumption: source is a vertex in G.
	 */
	public void DepthFirstSearch2(Vertex<T> source) {
		setAllUnvisited();

		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		stack.push(source);

		while (!stack.isEmpty()) {
			Vertex<T> v = stack.pop();
			if (!v.isVisited())
				System.out.print(v.getName() + " ");
			v.setVisited(true);
			Set<Vertex<T>> Nv = getNeighbours(v);
			for (Vertex<T> u : Nv) {
				if (!u.isVisited()) {
					stack.push(u);
					u.setParent(v);
				}
			}  
		}
	}



}
