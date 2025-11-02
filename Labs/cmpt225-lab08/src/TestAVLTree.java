import java.util.Collection;
import java.util.Iterator;

import avltree.AVLNode;
import avltree.AVLTree;

public class TestAVLTree {

	public static void testInsert() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(10);
		tree.insert(2);
		tree.insert(3);
		tree.insert(8);
		tree.insert(5);
		tree.insert(1);
		// expected tree
		//       3
		//      / \
		//     2   8
		//    /   / \
		//   1   5   10
		
		AVLNode<Integer> r = tree.getRoot(); 
		if (r != null && r.getData() == 3
				&& r.getLeftChild() != null
				&& r.getLeftChild().getData() == 2
				&& r.getRightChild() != null
				&& r.getRightChild().getData() == 8)
			System.out.println("testInsert OK");
		else
			System.out.println("testInsert ERROR");

	}


	public static void testRemove() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		tree.insert(3);
		tree.insert(2);
		tree.insert(8);
		tree.insert(7);
		tree.insert(1);
		tree.insert(10);
		tree.insert(20);
		// expected tree
		//       3
		//      / \
		//     2   8
		//    /   / \
		//   1   7   10
		//            \
		//            20
		tree.remove(1);
		// expected tree
		//       8
		//      / \
		//     3   10
		//    / \   \
		//   2   7   20
		//            
		AVLNode<Integer> r = tree.getRoot(); 
		if (r != null && r.getData() == 8
				&& r.getLeftChild() != null
				&& r.getLeftChild().getData() == 3
				&& r.getRightChild() != null
				&& r.getRightChild().getData() == 10)
			System.out.println("testRemove 1 OK");
		else
			System.out.println("testRemove 1 ERROR");

		tree.remove(10);
		// expected tree
		//       8
		//      / \
		//     3   20
		//    / \   
		//   2   7  
		//            
		AVLNode<Integer> r = tree.getRoot(); 
		if (r != null && r.getData() == 8
				&& r.getLeftChild() != null
				&& r.getLeftChild().getData() == 3
				&& r.getRightChild() != null
				&& r.getRightChild().getData() == 20)
			System.out.println("testRemove 2 OK");
		else
			System.out.println("testRemove 2 ERROR");
	}

	
	public static void testLargeTree() {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		for (int i = 0; i < 1000; i++)
			tree.insert(i);
		// TODO add testing here
	}
	


	public static void main(String[] args) {
		testInsert();
		testRemove();
		testLargeTree();
	}
}
