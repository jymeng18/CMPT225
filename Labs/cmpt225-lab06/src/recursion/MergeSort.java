package recursion;

import java.util.*;

public class MergeSort {

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

	private static class Operation {
		String op;
		int[] args;

		Operation(String op, int[] args) {
			this.op = op;
			this.args = args;
		}
	}

	public static void mergeSortIterative(int[] arr) {
		final String SORT = "SORT";
		final String MERGE = "MERGE";

		Stack<Operation> stack = new Stack<Operation>();
		stack.push(new Operation(SORT, new int[] { 0, arr.length - 1 }));

		Operation cur;
		while (!stack.isEmpty()) {
			cur = stack.pop();
//			System.out.println(cur.op + " " + Arrays.toString(cur.args) );
			if (cur.op == MERGE) {
				int start = cur.args[0];
				int mid = cur.args[1];
				int end = cur.args[2];
				merge(arr, start, mid, end);
			}
			else {// cur.op == SORT
				int start = cur.args[0];
				int end = cur.args[1];
				if (start < end) { // the subarray has length > 1
					int mid = (start + end) / 2;
					// push the operations onto the stack in the reverse order
					stack.push(new Operation(MERGE, new int[] { start, mid, end }));
					stack.push(new Operation(SORT, new int[] { mid + 1, end }));
					stack.push(new Operation(SORT, new int[] { start, mid }));
				}
			}
		}
	}

	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int[] arr = { 1, 6, 2, 10, -1, 9};
		System.out.println(Arrays.toString(arr));
		mergeSortIterative(arr);
		System.out.println(Arrays.toString(arr));
	}
}
