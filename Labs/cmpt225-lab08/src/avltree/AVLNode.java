package avltree;

public class AVLNode<T extends Comparable<T>> {
    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private AVLNode<T> parent;

	public AVLNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
	}

	public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, AVLNode<T> parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
	}

	public T getData() {
		return this.data;
	}

	public AVLNode<T> getLeftChild() {
		return this.left;
	}

	public AVLNode<T> getRightChild() {
		return this.right;
	}

	public AVLNode<T> getParent() {
		return this.parent;
	}

	public void setData(T data) {
        this.data = data;
	}
	public void setLeftChild(AVLNode<T> leftChild) {
        this.left = leftChild;
	}

	public void setRightChild(AVLNode<T> rightChild) {
        this.right = rightChild;
	}

	public void setParent(AVLNode<T> parent) {
        this.parent = parent;
	}
	
	public boolean isLeaf() {
		return (getLeftChild() == null && getRightChild() == null);
	}

	public boolean isRoot() {
		return (getParent() == null);
	}

}
