package basicdatastructures.mylinkedlists;

import java.util.*;
import java.util.LinkedList;

/**
 * Implementation of linked list
 *   
 * @author Igor
 *
 */

public class MyLinkedList<T> {

	class LinkedListNode {

		T data;
		LinkedListNode next;

		LinkedListNode(T data) {
			this.data = data;
			this.next = null;
		}

		LinkedListNode(T data, LinkedListNode next) {
			this.data = data;
			this.next = next;
		}
		
		public LinkedListNode getNext() {
			return next;
		}
	}

	private LinkedListNode head;
	private int length;

	public MyLinkedList() {
		this.head = null;
		this.length = 0;
	}
	
	public LinkedListNode head() {
		return this.head;
	}

	// example: -> ... -> 1 -> 2 -> 3 -> 4..
	// want to add 5 after 1
	// we'll get -> ... -> 1 -> 5 -> 2 -> 3 -> 4..
	public void addAfter(LinkedListNode node, T element) {
		if (node == null)
			return;
		LinkedListNode newNode = new LinkedListNode(element, node.next);
		node.next = newNode;
		length++;
	}

	// example: -> ... -> 1 -> 2 -> 3 -> 4..
	// get pointer to 1, and we want to remove 2
	public void removeAfter(LinkedListNode node) {
		if (node == null || node.next == null)
			return;
		node.next = node.next.next;
		length--;
	}

	public void addToHead(T element) {
		if (element == null)
			throw new IllegalArgumentException("Trying to add null to the list");

		LinkedListNode newNode = new LinkedListNode(element, head);
		head = newNode;
		length++;
	}

	public T removeFromHead() {
		if (head==null) // list is empty
			throw new NoSuchElementException("My linked list is empty");

		T ret = head.data;
		head = head.next;
		length--;
		return ret;
	}


	public void addToTail(T element) {
		if (element == null)
			throw new IllegalArgumentException("Trying to add null to the list");

		LinkedListNode newNode = new LinkedListNode(element, null);

		if(head == null)
			head = newNode;
		else {
			LinkedListNode node = head;
			while (node.next != null) // iterate until reaching the last node
				node = node.next;

			// here node.next == null
			node.next = newNode;
		}
		length++;
	}

	public T removeFromTail() {
		if (head == null)
			throw new NoSuchElementException("My linked list is empty");
		
		T ret;
		if (head.next == null) {
			ret = head.data;
			head = null;
		}
		else {
			LinkedListNode node = head;
			while (node.next.next != null)
				node = node.next;
			// node is the one before last
			ret =  node.next.data;	// remember the last element
			node.next = null; // disconnecting node.next from the list
		}
		length--;
		return ret;
	}

	public T get(int index) {
		if (index < 0 || index >= length)
			throw new IndexOutOfBoundsException("get(" + index + "), length = " + length);

		LinkedListNode node = head;
		for (int j = 0; j < index; j++)
			node = node.next;
		return node.data;
	}

	/**
	 * 
	 * @param index
	 * @param element
	 * @return the previous value in the given position
	 */
	public T set(int index, T element) {
		
		if (element == null)
			throw new IllegalArgumentException("Trying to add null to the list");
		
		if (index <0 || index >= length)
			throw new IndexOutOfBoundsException("set(" + index + "), length = " + length);

		LinkedListNode node = head;
		for (int j = 0; j < index; j++)
			node = node.next;
		T prevValue = node.data; // store the previous value
		node.data = element; // set the new value
		return prevValue;	// return the previous value
	}

	public int length() {
		return length;
		// if I didn't have the length,
		// I would need to iterate through the list 
	}
	
	public boolean isEmpty() {
		return length==0;
	}

	public boolean contains(T element) {
		LinkedListNode node = head;
		while (node != null) {
			if (node.data.equals(element)) // assumption data is never null
				return true;
			node = node.next;
		}
		return false;
	}

	/**
	 * removes all nodes containing the element
	 * @param element
	 */
	public void removeAllOccurences(T element) {

		// remove all elements in the beginning of the list
		while (head!=null && head.data.equals(element))
			head = head.next;

		if (head==null)
			return;

		// head is not null and head.data is not element
		// look one node forward, and remove it if needed
		LinkedListNode node = head;
		while (node.next != null) {
			if (node.next.data.equals(element))
				removeAfter(node);
			else
				node = node.next;
		}
	}

	@Override
	public String toString() {
		String ret = "";
		LinkedListNode node = head;
		int i=0;
		while (node != null) {
			ret =  ret.concat(i + ") " + node.data.toString() + "\n");
			node = node.next;
			i++;
		}

		return ret;
	}

}

