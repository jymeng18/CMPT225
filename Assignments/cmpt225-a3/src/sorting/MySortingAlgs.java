package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MySortingAlgs {

    public static void sortStrings(String[] a) {
        // Precondition: 'a' must exist
        if(a == null){
            return;
        }
        int n = a.length;

        // Bubble sort
        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                // Sort by character count then by lexicographically
                int compareVal;

                // Check if string lengths are unequal
                if(a[j].length() != a[j+1].length()){
                    compareVal = a[j].length() - a[j+1].length();
                }

                // If string lengths are equal, sort lexicographically
                else{
                    compareVal = a[j].compareTo(a[j+1]);
                }

                // Swap
                if(compareVal > 0){
                    String tempVal = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tempVal;
                }
            }
        }
    }

	/**
	 * Assumption arr[start...mid-1] is sorted and arr[mid...end] is sorted.
     * The function merges the two parts into a sorted subarray arr[start...end]
     * All elements outside arr[start...end] remain unchanged
	 */
	public static <T extends Comparable<T>> void merge(T[] arr, int start, int mid, int end) {
        ArrayList<T> tempArr = new ArrayList<>();
        int startPtr = start;
        int midPtr = mid;

        // Merge two sorted parts
        while(startPtr < mid && midPtr <= end){

            // Grab from first part
            if(arr[startPtr].compareTo(arr[midPtr]) <= 0){
                tempArr.add(arr[startPtr]);
                startPtr++;
            }

            // Grab from second part
            else{
                tempArr.add(arr[midPtr]);
                midPtr++;
            }
        }

        // There's a chance there's left over data not counted
        while(startPtr < mid){
            tempArr.add(arr[startPtr]);
            startPtr++;
        }
        while(midPtr <= end){
            tempArr.add(arr[midPtr]);
            midPtr++;
        }

        // Copy sorted & merged data back to source
        for(int i = 0; i < tempArr.size(); i++){
            arr[i + start] = tempArr.get(i);
        }
	}


	/**
	 * sorts the subarray arr[start...end] using the Merge Sort algorithm
	 */
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int start, int end) {
        if (start == end)
            return;

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid-1);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    /**
     * sorts the subarray arr using the Merge Sort algorithm
     */
    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

}
