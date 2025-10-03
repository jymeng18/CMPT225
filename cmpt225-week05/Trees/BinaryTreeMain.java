import binarytree.*;

public class BinaryTreeMain {
	public static BinaryTree<Integer> createTree() {
		// creating the tree
		//       5
		//      / \
		//     2   6
		//    / \   \
		//   1   4   8

		BTNode<Integer> node5 = new BTNode<Integer>(5);
		
		BTNode<Integer> node2 = new BTNode<Integer>(2);
		node5.setLeftChild(node2);
		BTNode<Integer> node1 = new BTNode<Integer>(1);
		node2.setLeftChild(node1);
		BTNode<Integer> node4 = new BTNode<Integer>(4);
		node2.setRightChild(node4);

		BTNode<Integer> node6 = new BTNode<Integer>(6, null, null, node5);
		node5.setRightChild(node6);

		BTNode<Integer> node8 = new BTNode<Integer>(8, null, null, node6);
		node6.setRightChild(node8);

		return new BinaryTree<Integer>(node5);
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = createTree();
		System.out.println("size = " + tree.size());
		System.out.println("Preorder: ");
		tree.preOrderIterative();
		System.out.println("Inorder: ");
		tree.inOrder();
	}

}
