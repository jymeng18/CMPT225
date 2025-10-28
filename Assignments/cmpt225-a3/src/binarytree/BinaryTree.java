package binarytree;

import java.util.*;

public class BinaryTree<T> {

    private final BTNode<T> root;

    public BinaryTree(BTNode<T> root) {
        this.root = root;
    }

    public BTNode<T> getRoot() {
        return root;
    }

    public int size() {
        return root.size();
    }

    public int height() {
        return root.height();
    }

    public void printInOrder() {
        root.printInOrder();
    }

    public void printPreOrder() {
        root.printPreOrder();
    }

    public void printPostOrder() {
        root.printPostOrder();
    }


    /**
     * returns the number of leaves in the tree
     */
    public int numberOfLeaves() {
        if(root == null){
            return 0;
        }

        Stack<BTNode<T>> stack = new Stack<>();
        int countLeaves = 0;

        // Push our root node
        stack.push(getRoot());
        while(!stack.isEmpty()){
            BTNode<T> node = stack.pop();
            if(node.getLeftChild() == null && node.getRightChild() == null) {
                countLeaves++;
            }

            // Keep pushing descendant nodes to the stack if existing
            if(node.getLeftChild() != null){
                stack.push(node.getLeftChild());
            }
            if(node.getRightChild() != null){
                stack.push(node.getRightChild());
            }
        }
        return countLeaves;
    }


    @Override
    public boolean equals(Object other) {

        // Check same object
        if(this == other){
            return true;
        }

        // Check it is of right type
        if(!(other instanceof BinaryTree<?>)){
            return false;
        }

        @SuppressWarnings("unchecked")
        BinaryTree<T> bt = (BinaryTree<T>) other;

        return equalsNode(this.getRoot(), bt.getRoot());
    }

    public boolean equalsNode(BTNode<T> node1, BTNode<T> node2){

        // If nodes are both null -> equal
        if(node1 == null && node2 == null){
            return true;
        }

        // One is null, other is not -> not equal
        if(node1 == null || node2 == null){
            return false;
        }

        if(node1.getData() != node2.getData()){
            return false;
        }
        if(!equalsNode(node1.getLeftChild(), node2.getLeftChild()) ){
            return false;
        }
        return equalsNode(node1.getRightChild(), node2.getRightChild());
    }

    /**
     * returns the number of vertices at depth k if k<0 throws
     * IllegalArgumentException
     */
    public int countDepthK(int k) {
        // Precondition: k >= 0
        if(k < 0){
            throw new IllegalArgumentException("Invalid k");
        }

        // If root is null -> no nodes
        if(getRoot() == null){
            return 0;
        }

        Queue<BTNode<T>> queue = new LinkedList<>();
        int currentDepth = 0; // Track current depth

        // Traverse to depth 'k'
        queue.offer(getRoot());
        while(!queue.isEmpty()){
            int levelSize = queue.size();

            // If we've reached depth 'k' return the num of nodes at this level
            if(currentDepth == k){
                return levelSize;
            }

            // BFS Approach
            for (int i = 0; i < levelSize; i++) {
                BTNode<T> cur = queue.poll();
                assert cur != null;

                // Process all nodes on the level
                if (cur.getLeftChild() != null) {
                    queue.offer(cur.getLeftChild());
                }
                if (cur.getRightChild() != null) {
                    queue.offer(cur.getRightChild());
                }
            }
            currentDepth++; // Move to next level
        }
        // If we reach here, k is greater than tree's depth
        return 0;
    }

    /**
     * returns a preOrder iterator for the tree
     */
    public Iterator<T> preOrderIterator() {
        return new PreOrderIterator<>(root);
    }
}
