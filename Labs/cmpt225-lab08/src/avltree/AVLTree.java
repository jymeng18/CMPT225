package avltree;

import java.util.NoSuchElementException;

public class AVLTree<T extends Comparable<T>> {
	AVLNode<T> root;

	/**
	 * creates an empty AVL tree
	 */
	public AVLTree() {
        this.root = null;
	}
	

	public AVLNode<T> getRoot() {
		return this.root;
	}
	
	/**
	 * returns a node containing item in the AVL tree
	 * if item is not in the tree, throws NoSuchElementException
	 */
	public AVLNode<T> find(T item) {
		AVLNode<T> curNode = getRoot();

        while(curNode != null){
            int cmpVal = item.compareTo(curNode.getData());
            if(cmpVal == 0){
                return curNode;
            }
            else if (cmpVal < 0) {
                // Item is less than curNode, move left
                curNode = curNode.getLeftChild();
            }
            else {
                curNode = curNode.getRightChild();
            }
        }
		throw new NoSuchElementException("Item is not in the list");
	}

	/**
	 * adds a new item to the AVL tree
	 * duplicates are allowed
	 */
	public AVLNode<T> insert(T item) {
		// Create new node
        AVLNode<T> newNode = new AVLNode<>(item);

        // if empty tree
        if(getRoot() == null){
            root = newNode;
            return root;
        }

        AVLNode<T> current = root;
        AVLNode<T> parent = null;

        while(current != null){
            parent = current; // always saves previous value of current

            // Insert left or right
            int cmp = item.compareTo(current.getData());
            if(cmp <= 0){
                current = current.getLeftChild();
            }
            else{
                current = current.getRightChild();
            }
        }

        // Once current hits the end, insert
        newNode.setParent(parent);
        assert parent != null;
        int cmpVal = item.compareTo(parent.getData());
        if(cmpVal <= 0){
            parent.setLeftChild(newNode);
        }
        else{
            parent.setRightChild(newNode);
        }

        // May need rebalancing after insertion


		return newNode;
	}


	/**
	 * remove item from the AVL tree
	 * if item is not in the tree, throws NoSuchElementException
	 */
	public void remove(T item) {
		// TODO implement me
	}
    private int height(AVLNode<T> node){
        if(node == null){ return -1; }

        return 1 + Math.max(height(node.getLeftChild()), height(node.getRightChild()));
    }


    private int balanceFactor(AVLNode<T> node){
        if(node == null){ return 0; }

        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private void rebalance(AVLNode<T> node){
        while(node != null){
            int balance = balanceFactor(node);
        }

        return;
    }

}
