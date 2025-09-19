package searchsort;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Igor
 *
 */
public class UseSort {
    
	public static void main(String[] args) {
		int array[] = new int[20];
		
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(100);
			System.out.print(array[i] + " ");
		}

		System.out.println("\n---Sorting...\n");
		Arrays.sort(array); // generic sorting algorithm
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		
	}

}
