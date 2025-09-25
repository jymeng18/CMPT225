/*
 * Filename: ArrayIterator.java
 *
 * Desc: Iterator for an Array of ints
 *
 * Author: Jerry Meng
 *
 * Last Modified: Sept 2025
 */


package integeriterators;

import java.util.NoSuchElementException;

public class ArrayIterator implements IntegerIterator
{
	/**
	 * Creates an iterator for ar 
	 */

    private int iterator = -1;
    private final int[] ar;
    private int direction = 1;

	public ArrayIterator(int[] ar) {
        if(ar == null || ar.length == 0){
            throw new IllegalArgumentException("array must not be null or empty");
        }
        this.ar = ar;
	}

	@Override
	public boolean hasNext() {

        // If user reverses at beginning
        if(iterator == -1){
            return true;
        }

        if(direction == 1){
            return iterator < ar.length - 1; // Forwards direction
        }
        else{
            return iterator > 0; // Backwards direction
        }
	}
	
	@Override
	public Integer next() {
		if(!hasNext()){
;		    throw new NoSuchElementException();
        }

        if(iterator == -1){
            iterator = 0; // first access always gives first element
        }
        else{
            iterator += direction;
        }
        return ar[iterator];
	}
	
	public void reverse() {
        direction *= -1;
    }
}
