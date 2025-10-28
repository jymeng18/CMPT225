package binarytree;
import java.util.*;

public class BinaryTree<T> {

	protected BTNode<T> root;

	public BinaryTree(BTNode<T> root) {
		this.root = root;
	}

	public BTNode<T> getRoot() {
		return root;
	}


	public int size() {
		return root.size();
	}


	public int sizeIterative() {
		int size = 0;
		Stack<BTNode<T>> stack = new Stack<BTNode<T>>();
		stack.push(root);
		// each node is added to the stack exactly once
		// removed exactly once
		// and when removed, we update the size
		BTNode<T> currentNode = null;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			// every time we remove a node from the stack
			// we increment the size by 1
			// push the children onto the stack
			size++;

			// push the children in the reverse order 
			// so that the left child is processed first
			if (currentNode.getRightChild() != null)
				stack.push(currentNode.getRightChild());
			if (currentNode.getLeftChild() != null)
				stack.push(currentNode.getLeftChild());
		}
		return size;
	}

	public int height() {
		return root.height();
	}

	private void printInOrder(BTNode<T> r) {
		if (r==null)
			return;
		printInOrder(r.getLeftChild());
		System.out.println(r.getData());
		printInOrder(r.getRightChild());
	}
	
	public void printInOrder() {
//		root.printInOrder();
		printInOrder(this.getRoot());
	}

	public void printPreOrder() {
		root.printPreOrder();
	}

	public void printPostOrder() {
		root.printPostOrder();
	}

	public ArrayList<BTNode<T>> preOrder() {
		return root.preOrder();
	}

	public ArrayList<BTNode<T>> inOrder() {
		return root.inOrder();
	}

	public ArrayList<BTNode<T>> postOrder() {
		return root.postOrder();
	}


	public ArrayList<BTNode<T>> preOrderIterative() {
		
		ArrayList<BTNode<T>> ret = new ArrayList<BTNode<T>>();

		Stack<BTNode<T>> stack = new Stack<BTNode<T>>();

		BTNode<T> current;

		stack.push(root);
		while (!stack.isEmpty()) {
			current = stack.pop();
			ret.add(current); // adds in the end of the list
			// note that we push the children to stack in the reverse order
			if (current.getRightChild() != null)
				stack.push(current.getRightChild());
			if (current.getLeftChild() != null)
				stack.push(current.getLeftChild());
		}

		return ret;
	}



	public ArrayList<BTNode<T>> BFS() {
		ArrayList<BTNode<T>> ret = new ArrayList<BTNode<T>>();
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();

		BTNode<T> current;

		queue.addLast(root);
		while (!queue.isEmpty()) {
			current = queue.removeFirst();
			ret.add(current);
			// now the order of the children is left to right
			if (current.getLeftChild() != null)
				queue.addLast(current.getLeftChild());
			if (current.getRightChild() != null)
				queue.addLast(current.getRightChild());
		}

		return ret;
	}


	public void printBFSseparated() {
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();

		BTNode<T> current;
		
		// separator is a special node indicating the end of a layer
		BTNode<T> separator = new BTNode<T>(null);
		int depth = 0;

		queue.addLast(separator);
		queue.addLast(root);
		while (!queue.isEmpty()) {
			current = queue.removeFirst();
			if (current == separator) {
				// if queue is empty, then we are done
				// otherwise, we are starting the next layer
				if (!queue.isEmpty()) {
					System.out.println("Layer " + depth + ":");
					depth++;
					queue.addLast(separator);
				}
			}
			else {
				System.out.println(current.getData());
				if (current.getLeftChild() != null)
					queue.addLast(current.getLeftChild());
				if (current.getRightChild() != null)
					queue.addLast(current.getRightChild());
			}
		}


	}


}
