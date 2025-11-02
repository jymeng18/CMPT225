package heap;

import java.util.*;

public class TestHeap {

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
		System.out.println(heap);
		heap.removeTop();
		//  	  2 
		//     4      3
		//   7   9  6   5
		//  8
		System.out.println("removed 1: " + heap);

		heap.removeTop();
		//  	 3 
		//    4     5
		//   7 9   6 8
		System.out.println("removed 2: " + heap);

		heap.removeTop();
		//  	 4 
		//    7     5
		//   8 9   6   
		System.out.println("removed 4: " + heap);

		System.out.println("--------------");

		

		ArrayList<Integer> listOfNnumbers2 = new ArrayList<Integer>();
		listOfNnumbers2.addAll(Arrays.asList(9,7,6,8,3,4,2,5,0,1));

		System.out.println("Build heap from " + listOfNnumbers2);

		Heap<Integer> heap2 = new Heap<Integer>(listOfNnumbers2);
		// starts with
		//             9
		//         7       6
		//       8   3   4   2
		//      5 0 1 
		//
		// builds the heap:
		//             0
		//         1       2
		//       5   3   4   6
		//      7 8 9 
		//
		System.out.println("The result:     " + heap2);


		
		ArrayList<Integer> listOfNnumbers3 = new ArrayList<Integer>();
		listOfNnumbers3.addAll(Arrays.asList(9,7,6,8,15,3,4,22,2,5,10,20,0,1));

		Heap.heapSort(listOfNnumbers3);
		System.out.println("Sorted: " + listOfNnumbers3);

	}

}
