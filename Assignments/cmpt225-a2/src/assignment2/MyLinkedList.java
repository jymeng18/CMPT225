package assignment2;

import java.util.NoSuchElementException;

/**
 *
 * This is a generic class representing a list of objects.
 * The operations on the list are as follows:
 * - adding and removing elements from the left and from the right.
 * - reversing the list
 * - getting the size of the list
 * **All operations must run in O(1) time.**
 */
public class MyLinkedList<T> {

    private static class Node <T> {
        Node<T> next ;
        Node<T> prev;
        T element;

        public Node(T element){
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int elementCount;
    private boolean isReversed;

	/**
	 * The constructor creates an empty list
	 */
	public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.elementCount = 0;
        this.isReversed = false;
	}

	/**
	 * Adds the new item to the left of the list. 
	 */
	public void addLeft(T item) {
        // Edge case: List is empty
        if(isEmpty()) {
            Node<T> newNode = new Node<>(item);
            head = newNode;
            tail = newNode;
            elementCount++;
            return;
        }

        // General case
        Node<T> newNode = new Node<>(item);

        if(isReversed){
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            elementCount++;
        }
	}

	/**
	 * Adds the new item to the right of the list. 
	 */
	public void addRight(T item) {
        // Edge case: List is empty
        if(isEmpty()) {
            Node<T> newNode = new Node<>(item);
            head = newNode;
            tail = newNode;
            elementCount++;
            return;
        }
        // General case
        Node<T> newNode = new Node<>(item);

        if(isReversed){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        elementCount++;
	}

	/**
	 * Removes the leftmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeLeft() {
		// Precondition: List is not empty
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }

        // Removed element to return
        T nodeVal;

        // Removing element on the right, bc its reversed.
        if(isReversed){
            nodeVal = tail.element;
            tail = tail.prev;

            // Handle edge case
            if(tail != null){
                tail.next = null;
            }
            else{
                head = null; // empty list now
            }
        }

        // General case
        else {
            nodeVal = head.element;
            head = head.next;

            // Handle edge case
            if(head != null){
                head.prev = null;
            }
            else{
                tail = null; // empty list now
            }
        }

        elementCount--;
        return nodeVal;
	}

	/**
	 * Removes the rightmost item from the list and returns it.
	 * If the list is empty, throws NoSuchElementException.
	 */
	public T removeRight() {
        // Precondition: List must not be empty
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
        T nodeVal;

        // Removing element on the left, bc its reversed,
        if(isReversed){
            nodeVal = head.element; // Hold value to be removed
            head = head.next;

            // Handle edge cases
            if(head != null){
                head.prev = null; // no element before the head
            }
            else{
                tail = null; // empty list
            }
        }

        // General case
        else{
            nodeVal = tail.element; // Hold value to be removed
            tail = tail.prev;

            // Handle edge cases
            if(tail != null){
                tail.next = null; // no elements after tail
            }
            else{
                head = null; // empty list
            }
        }

        elementCount--;
		return nodeVal;
	}


	/**
	 * Reverses the list
	 */
	public void reverse() {
        isReversed = !isReversed;
    }

	/**
	 * Returns the size of the list.
	 */
	public int size() {
		return elementCount;
	}

	/**
	 * Returns true if list is empty, and returns false otherwise.
	 */
	public boolean isEmpty() {
        return head == null && tail == null && elementCount == 0;
    }

}
