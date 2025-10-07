package binarytree;

import java.util.NoSuchElementException;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

	public BinarySearchTree() {
		super(null);
	}

	public BTNode<T> find(T item) {
		BTNode<T> cur = getRoot();
		while (cur != null && cur.getData().compareTo(item) != 0) {
			if (cur.getData().compareTo(item) > 0)
				cur = cur.getLeftChild();
			else
				cur = cur.getRightChild();
		}
		return cur;
	}

	public BTNode<T> insert(T item) {
		BTNode<T> parent = null;
		BTNode<T> cur = getRoot();
		while (cur != null) {
			parent = cur;
			if (cur.getData().compareTo(item) > 0)
				cur = cur.getLeftChild();
			else
				cur = cur.getRightChild();
		}
		BTNode<T> newNode = new BTNode<T>(item);

		if (parent == null) // first node inserted
			root = newNode;
		else {
			if (parent.getData().compareTo(item) > 0)
				parent.setLeftChild(newNode);
			else
				parent.setRightChild(newNode);
		}
		return newNode;
	}

	// assumption: node has right child
	private BTNode<T> successor(BTNode<T> node) {
		BTNode<T> cur = node.getRightChild();
		while (cur.getLeftChild() != null)
			cur = cur.getLeftChild();
		return cur;
	}

	// returns one of the children of node
	// if node is a leaf, returns null
	private BTNode<T> getChild(BTNode<T> node) {
		if (node.getLeftChild() != null)
			return node.getLeftChild();
		else
			return node.getRightChild();
	}

	// node has no children or one child
	private void removeNode01(BTNode<T> node) {
		BTNode<T> child = getChild(node);
		if (root == node)
			root = child;
		else {
			if (node.getParent().getLeftChild() == node)
				node.getParent().setLeftChild(child);
			else
				node.getParent().setRightChild(child);
		}
	}

	// node has 2 children
	private void removeNode2Children(BTNode<T> node) {
		BTNode<T> successor = successor(node);
		node.setData(successor.getData());
		removeNode01(successor);
	}

	private void removeNode(BTNode<T> node) {
		// if node has no children or 1 child
		if (node.getLeftChild() == null || node.getRightChild() == null)
			removeNode01(node);
		else { // node has 2 children
			removeNode2Children(node);
		}

	}

	public void remove(T item) {
		BTNode<T> node = find(item);

		if (node == null)
			throw new NoSuchElementException(item + "not found");
		else
			removeNode(node);
	}

}
