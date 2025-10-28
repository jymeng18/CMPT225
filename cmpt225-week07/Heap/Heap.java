import java.util.*;
import java.lang.Comparable;

public class Heap<T extends Comparable<T>> {

	private ArrayList<T> array;

	public Heap() {
		array = new ArrayList<T>();
	}

	/**
	 * Creates Heap on the list as
	 * @param list
	 */
	public Heap(ArrayList<T> list) {
		array = list;
		buildHeap();
	}
	
	public ArrayList<T> getArray() {
		return array;
	}

	public T getMin() {
		return array.get(0);
	}

	public void add(T item) {
		array.add(item); // append to the end of the list

		// propagate up
		int i = array.size() - 1;
		while (i>0 && array.get(i).compareTo(array.get(getParent(i))) < 0) {
			// swap array[i] and array[parent of i]
			swap(i, getParent(i));
		}
	}

	public T removeMin() {
		T ret = array.get(0);

		// TODO implement me
		array.set(0, array.get(array.size()-1));
		array.remove(array.size()-1);

		if (size()>0) 
			heapify(0);

		return ret;
	}

	/**
	 * Implementation of the heapSort algorithm
	 * @param <E>
	 * @param list
	 */
	public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
		Heap<E> heap = new Heap<E>(list);
		heap.heapSort();
	}


	public String toString() {
		return array.toString();
	}

	public int size() {
		return array.size();
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
		if (i<array.size()) {
			int j = minVertexOrChildren(i);
			if (j != i) {
				swap(i,j);
				heapify(j);
			}
		}
	}

	private int minVertexOrChildren(int i) {
		int min = i;
		if (getLeftChild(i) < array.size() && array.get(getLeftChild(i)).compareTo(array.get(min)) < 0) {
			min = getLeftChild(i); 
		}
		if (getRightChild(i) < array.size() && array.get(getRightChild(i)).compareTo(array.get(min)) < 0) {
			min = getRightChild(i); 
		}

		return min;
	}

	/**
	 * builds heap inside the given arraylist
	 */
	private void buildHeap() {
		// heapify each node 
		for (int i = size()-1; i >= 0; i--)  
			heapify(i); 
	}

	/**
	 * implementation of heapSort
	 */
	private void heapSort() {
		// TODO implement me
	}

	public static void main(String[] args) {

		Heap<Integer> heap = new Heap<Integer>();
		heap.add(4);
		heap.add(1);
		heap.add(6);
		heap.add(8);
		heap.add(2);
		heap.add(3);
		heap.add(5);
		heap.add(7);
		heap.add(9);
		//  	   1 
		//     2      3
		//   7   4  6   5
		//  8 9
		System.out.println(heap.array);
		heap.removeMin();
		//  	  2 
		//     4      3
		//   7   9  6   5
		//  8
		System.out.println("removed 1: " + heap.array);

		heap.removeMin();
		//  	 3 
		//    4     5
		//   7 9   6 8
		System.out.println("removed 2: " + heap.array);

		heap.removeMin();
		//  	 4 
		//    7     5
		//   8 9   6   
		System.out.println("removed 4: " + heap.array);

		System.out.println("--------------");

		

		ArrayList<Integer> listOfNnumbers = new ArrayList<Integer>();
		listOfNnumbers.addAll(Arrays.asList(9,7,6,8,3,4,2,5,0,1));

		System.out.println("Build heap from " + listOfNnumbers);

		Heap<Integer> heap2 = new Heap<Integer>(listOfNnumbers);
		// builds the heap:
		//             0
		//         1       2
		//       5   3   4   6
		//      7 8 9 
		//
		System.out.println("The result:     " + heap2.getArray());
	}

}
