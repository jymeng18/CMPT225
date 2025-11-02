package heap;

import java.util.*;
import java.lang.Comparable;

public class Heap<T extends Comparable<T>> {

	// constants used to specify min heap or max heap
	public static final int MIN = 1;
	public static final int MAX = -1;
	
	private ArrayList<T> array;
	private int size;
	private int minOrMax; // specifies min heap or max heap


	/**
	 * Creates an empty min Heap
	 * @param list
	 */
	public Heap() {
		array = new ArrayList<T>();
		size = 0;
		minOrMax = MIN;
	}


	/**
	 * Creates an empty Heap
	 * @param minmax indicates MinHeap or MaxHeap using Heap.MIN or Heap.MAX
	 */
	public Heap(int minmax) {
		array = new ArrayList<T>();
		size = 0;
		minOrMax = minmax;
	}

	/**
	 * Creates min Heap on the list as
	 * @param list
	 */
	public Heap(ArrayList<T> list) {
		array = list;
		size = list.size();
		minOrMax = MIN;
		buildHeap();
	}

	/**
	 * Creates a min Heap on the list as
	 * @param list
	 * @param minmax indicates MinHeap or MaxHeap using Heap.MIN or Heap.MAX
	 */
	public Heap(ArrayList<T> list, int minmax) {
		array = list;
		size = list.size();
		minOrMax = minmax;
		buildHeap();
	}



	/**
	 * Implementation of the heapSort algorithm
	 * @param list
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		// TODO implement me
		// hint: use max heap
	}
	

	public ArrayList<T> getArray() {
		return array;
	}

	public T getTop() {
		return array.get(0);
	}

	public void add(T item) {
		if (array.size() > size)
			array.set(size, item); // append to the end of the list
		else
			array.add(item);
		size++;

		// propagate up
		int i = size - 1;
		while (i>0 && array.get(i).compareTo(array.get(getParent(i)))*minOrMax < 0) {
			// swap array[i] and array[parent of i]
			swap(i, getParent(i));
		}
	}

	public T removeTop() {
		T ret = array.get(0);

		array.set(0, array.get(size-1));
		size--;

		if (size>0) 
			heapify(0);

		return ret;
	}


	/**
	 * builds heap inside the given arrayList
	 */
	private void buildHeap() {
		// heapify each node 
		for (int i = size-1; i >= 0; i--)  
			heapify(i); 
	}


	public String toString() {
        Iterator<T> it = array.iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i=0;i<size;i++) {
            T e = it.next();
            sb.append(e);
            if (i<size-1)
            	sb.append(',').append(' ');
        }
        sb.append(']');
        return sb.toString();
	}

	public int size() {
		return size;
	}

	private int getLeftChild(int i) {
		return 2*i+1;
	}

	private int getRightChild(int i) {
		return 2*i+2;
	}

	private int getParent(int i) {
		return ((i+1)/2)-1;
	}

	private void swap(int i, int j) {
		T tmp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, tmp);
	}

	private void heapify(int i) {
		if (i<size()) {
			int j = topVertexOrChildren(i);
			if (j != i) {
				swap(i,j);
				heapify(j);
			}
		}
	}

	private int topVertexOrChildren(int i) {
		int top = i;

		if (getLeftChild(i) < size
				&& array.get(getLeftChild(i)).compareTo(array.get(i))*minOrMax < 0)
			top = getLeftChild(i); 
		
		if (getRightChild(i) < size
				&& array.get(getRightChild(i)).compareTo(array.get(top))*minOrMax < 0)
			top = getRightChild(i); 

		return top;
	}


}
