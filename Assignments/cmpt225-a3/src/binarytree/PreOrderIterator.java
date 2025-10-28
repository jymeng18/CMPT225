package binarytree;

import java.util.*;

public class PreOrderIterator<T> implements Iterator<T> {
    private final Stack<BTNode<T>> stack;

    public PreOrderIterator(BTNode<T> root) {
        stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        BTNode<T> node = stack.pop();

        // Push right first, then left (so left is processed first)
        if (node.getRightChild() != null) {
            stack.push(node.getRightChild());
        }
        if (node.getLeftChild() != null) {
            stack.push(node.getLeftChild());
        }

        return node.getData();
    }
}