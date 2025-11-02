import java.util.*;

public class SelectionAlgorithm {

	// assumption start<=end<=start+4
	private static int getMedian(int A[], int start, int end) {
		// TODO implement me
		return -1;
	}
	
	// the function gets an array A[start...end]
	// it partitions the arrays into 5-tuples 
	// and returns an array with the median of each 5-tuple
	public static int[] arrayOfMedians(int[] A, int start, int end) {
		// TODO implement me
		return null;
	}
	
	// rearranges the elements of A[start,end]
	// so that all numbers<M are on the left of midPt
	// and all numbers>M are on the right of midPt
	// the function returns the index of midPt after rearrangement
	public static int rearrange(int A[], int M, int start, int end) {
		// TODO implement me
		return -1;
	}

	// A helper method for Selection sort which takes the boundaries as parameters
	// gets an array A, and start <= k<= end
	// returns the k'th smallest element in A
	// Assumption: A.length>end
	public static int selectionAlgorithm(int A[], int k, int start, int end) {
		if (start==end)
			return A[k];

		// the algorithm is for the case of start < end
		int[] medians = arrayOfMedians(A, start, end);
		int M = selectionAlgorithm(medians, medians.length/2); // the median of the meians
		
		int Mindex = rearrange(A, M, start, end);
		if (Mindex==k)
			return M;
		else if (Mindex>k) // search to the left of M in the interval [start, Mindex-1]
			return selectionAlgorithm(A, k, start, Mindex-1);
		else // (Mindex<k) : search to the right of M in the interval [Mindex+1, end]
			return selectionAlgorithm(A, k, Mindex+1, end);
		
	}

	// Selection sort algorithm
	public static int selectionAlgorithm(int A[], int k) {
		return selectionAlgorithm(A, k, 0, A.length-1);
	}

	public static void main(String[] args) {
		int p = 37;
		int A[] = new int[p];
		for (int i = 0; i < A.length; i++)
			A[i] = (19 * i + 8) % p;
		
		int n = 15;
		System.out.println("the " + n + "'th number is A is " + selectionAlgorithm(A, n));
		// the n'th number should be n (start counting from zero) 
	}
}
