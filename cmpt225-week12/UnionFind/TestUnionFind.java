import java.util.Vector;

public class TestUnionFind<T> {

	public static void testSameSet(UnionFindTicket n1, UnionFindTicket n2) {
		if (UnionFind.find(n1) == UnionFind.find(n2))
			System.out.println("n1 and n2 are in the same set");
		else
			System.out.println("n1 and n2 are in different sets");
	}

	public static void main(String[] args) {
		UnionFindTicket n1 = UnionFind.makeSet(1);
		UnionFindTicket n2 = UnionFind.makeSet(new Vector<Integer>());
		UnionFindTicket n3 = UnionFind.makeSet(3.6);
		UnionFindTicket n4 = UnionFind.makeSet("HELLO");
		UnionFindTicket n5 = UnionFind.makeSet(5);	// it is casted into Integer(5) 
		// UnionFind.Node n6 = = UnionFind.makeSet("Six"); -- UnionFind.Node is a private class 
		testSameSet(n1, n2);

		System.out.println("union(n1, n3)"); // {1,3} {2} {4} {5}
		UnionFind.union(n1, n3);

		System.out.println("union(n4, n5)");  // {1,3} {2} {4,5}
		UnionFind.union(n4, n5);

		System.out.println("union(n2, n5)"); //  // {1,3} {2,4,5}
		UnionFind.union(n2, n5);

		testSameSet(n1, n2);

		System.out.println("union(n1, n4)"); // {1,2,3,4,5}
		UnionFind.union(n1, n4);

		testSameSet(n1, n2);


	}	
}
