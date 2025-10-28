package graph;

public class TestGraphs {

	public static Graph<String> createGraph() {
		//
		//
		//
		//   A --- B --- C --- J --- I
		//   |     | \   |           |
		//   |     |   \ |           |
		//   D --- E --- F --- G --- H
		//
		Graph<String> graph = new Graph<String>();
		graph.addVertex(new Vertex<String>("A"));
		// more convenient
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");
		graph.addVertex("J");

		graph.addEdge("A","B");
		graph.addEdge("A","D");
		graph.addEdge("B","C");
		graph.addEdge("B","E");
		graph.addEdge("B","F");
		graph.addEdge("C","F");
		graph.addEdge("D","E");
		graph.addEdge("E","F");
		graph.addEdge("G","F");

		graph.addEdge("G","H");
		graph.addEdge("C","J");
		graph.addEdge("I","J");
		graph.addEdge("I","H");

		return graph;
	}

	public static void testBFS(Graph<String> G, String name) {
		System.out.print("BFS on G starting from " + name + ": ");
		G.BreadthFirstSearch(G.getVertexByName(name));
		System.out.println("");

		// Here the parents of the vertices are the BFS tree starting from the source 
		System.out.print("The path from G to " + name + ": ");
		G.printPath(G.getVertexByName("G"));
	}


	public static void testDFS(Graph<String> G, String name, int i) {
		if (i==1) {
			System.out.print("DFS *mark visited at push() on G starting from " + name + ": ");
			G.DepthFirstSearch1(G.getVertexByName(name));
		}
		else {
			System.out.print("DFS *mark visited at pop() on G starting from " + name + ": ");
			G.DepthFirstSearch2(G.getVertexByName(name));
		}
		System.out.println("");

		// Here the parents of the vertices are the DFS tree starting from the source 
		System.out.print("The path from G to " + name + ": ");
		G.printPath(G.getVertexByName("G"));
	}
	
	public static void main(String[] args) {
		Graph<String> G = createGraph();
		testBFS(G,"A");
		System.out.println("--------");
		testBFS(G,"B");
		System.out.println("--------");
		testDFS(G,"E",1);
		System.out.println("--------");
		testDFS(G,"E",2);

	}
}
