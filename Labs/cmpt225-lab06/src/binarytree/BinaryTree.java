package binarytree;

import java.util.*;

public class BinaryTree<T> {

	private BTNode<T> root;

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


	public int heightIterative() {
        if(root == null){
            return 0;
        }

        int height = 0;
        Queue<BTNode<T>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++){
                BTNode<T> node = queue.poll();
                if(node.getLeftChild() != null){
                    queue.offer(node.getLeftChild());
                }
                if(node.getRightChild() != null){
                    queue.offer(node.getRightChild());
                }
            }
            height++;
        }
		return height;
	}

	public int numberOfLeaves() {
        if(root == null){
            return 0;
        }
        Stack<BTNode<T>> stack = new Stack<>();
        stack.push(root);
        int leaves = 0;

        while(!stack.isEmpty()){
            BTNode<T> cur = stack.pop();
            if(cur.getLeftChild() == null && cur.getRightChild() == null){
                leaves++;
            }

            if(cur.getLeftChild() != null){
                stack.push(cur.getLeftChild());
            }
            if(cur.getRightChild() != null){
                stack.push(cur.getRightChild());
            }
        }

		return leaves;
	}

	public BinaryTree<T> clone() {
        BinaryTree<T> clonedBST = new BinaryTree<>(this.root);
		return clonedBST;
	}

	public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(obj != this){
            return false;
        }
		return false;
	}

	public List<T> listOfAllItems() {
		List<T> list = new ArrayList<>();
        Stack<BTNode<T>> tempStack = new Stack<>();

        tempStack.push(root);
        while(!tempStack.isEmpty()){
            BTNode<T> cur = tempStack.pop();
            list.add(cur.getData());

            if(cur.getLeftChild() != null){
                tempStack.push(cur.getLeftChild());
            }
            if(cur.getRightChild() != null){
                tempStack.push(cur.getRightChild());
            }
        }
		return list;
	}

}
