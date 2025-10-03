import java.util.*;

public class SortingAlgs {

	public static void swap(int[] ar, int i, int j) {
		int tmp = ar[i];
		ar[i] = ar[j];
		ar[j] = tmp;
	}

	/**
	 * 
	 * @param arr
	 * @param start
	 * @param mid
	 * @param end   Assumption arr[start...mid] is sorted and arr[mid+1...end] is
	 *              sorted The function merges the two parts into a sorted subarray
	 *              arr[start...end]
	 */
	public static void merge(int[] arr, int start, int mid, int end) {
		int tmp[] = new int[end - start + 1];
		int ptr1 = start;
		int ptr2 = mid + 1;
		int next = 0;
		while (ptr1 <= mid && ptr2 <= end) {
			if (arr[ptr1] < arr[ptr2])
				tmp[next++] = arr[ptr1++];
			else
				tmp[next++] = arr[ptr2++];
		}

		// if the first half still has elements left, copy them to the end of the second
		// half
		if (ptr2 == end + 1) {
			int eltsLeft = mid - ptr1 + 1;
			System.arraycopy(arr, ptr1, arr, end - eltsLeft + 1, eltsLeft);
		}

		// copy tmp into arr
		System.arraycopy(tmp, 0, arr, start, next);
	}

	/**
	 * Helper function:
	 * sorts the subarray arr[start...end]
	 */
	public static void mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return;

		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		merge(arr, start, mid, end);
	}

	/**
	 * Merge sort run in O(n log(n)) time
	 */
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	/**
	 * Insertion sort run in O(n^2) time
	 */
	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int j = i - 1;
			while (j >= 0 && arr[j] > arr[j + 1]) {
				swap(arr, j, j + 1);
				j--;
			}
		}

	}

	public static final int LEN = 1000000;
	// create random arrays of different lengths: 20,1000, 1000000
	// and test the different sorting algorithms on them
	
	public static void main(String[] args) {
		int[] arr1 = new int[20]; 
		for (int i = 0; i < 20; i++) {
			arr1[i] = (i*i)%27 + i*i; 
		}
		int[] arr2 = Arrays.copyOf(arr1, LEN);
		int[] arr3 = Arrays.copyOf(arr1, LEN);
		
		
		long start1 = System.currentTimeMillis();
		Arrays.sort(arr1);
		long end1 = System.currentTimeMillis();
		System.out.println("Java implemented Quicksort: Elapsed Time in milli seconds: " + (end1 - start1));


		long start2 = System.currentTimeMillis();
		mergeSort(arr2);
		long end2 = System.currentTimeMillis();
		System.out.println("Merge Sort: Elapsed Time in milli seconds: " + (end2 - start2));
		
		
		long start3 = System.currentTimeMillis();
		insertionSort(arr3);
		long end3 = System.currentTimeMillis();
		System.out.println("Insertion Sort: Elapsed Time in milli seconds: " + (end3 - start3));

	}
}
