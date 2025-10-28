import binarytree.*;

public class TestBST {
	public static BinarySearchTree<Integer> createBST() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8
		//  /   /   / \
		// 0   3    7  10
 		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(1);
		bst.insert(6);
		bst.insert(4);
		bst.insert(3);
		bst.insert(8);
		bst.insert(10);
		bst.insert(0);
		bst.insert(7);
		return bst;
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = createBST();
		System.out.println("size = " + tree.size());
		System.out.println("Preorder: ");
		tree.printPreOrder();
		System.out.println("Inorder: ");
		tree.printInOrder();
		System.out.println("Remove 8...");
		tree.remove(8);
		System.out.println("Preorder: ");
		tree.printPreOrder();
		System.out.println("Inorder: ");
		tree.printInOrder();
		System.out.println("Remove 4...");
		tree.remove(4);
		System.out.println("Preorder: ");
		tree.printPreOrder();
		System.out.println("Inorder: ");
		tree.printInOrder();
	}

}
