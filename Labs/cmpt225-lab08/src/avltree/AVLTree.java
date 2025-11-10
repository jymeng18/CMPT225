package avltree;

import java.util.NoSuchElementException;

public class AVLTree<T extends Comparable<T>> {


	AVLNode<T> root;

	/**
	 * creates an empty AVL tree
	 */
	public AVLTree() {
	}
	

	public AVLNode<T> getRoot() {
		return null;
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
                // Item is less then curNode, move left
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
		// TODO implement me
		return null;
	}


	/**
	 * remove item from the AVL tree
	 * if item is not in the tree, throws NoSuchElementException
	 */
	public void remove(T item) {
		// TODO implement me
	}


}
