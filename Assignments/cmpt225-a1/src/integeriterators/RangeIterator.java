/*
 * Filename: RangeIterator.java
 *
 * Author: Jerry Meng
 *
 * Desc: Iterator for Ranges of ints
 *
 * Last Modified: Sept 2025
 */

package integeriterators;

import java.util.NoSuchElementException;

public class RangeIterator implements IntegerIterator {

    private final int start;
    private final int end;
    private int current;
    private int direction;


	/**
	 * Creates an iterator for the finite sequence 0,1,2...n-1
	 */
	public RangeIterator(int n) {
		// Validate Parameters
        if(n <= 0){
            throw new IllegalArgumentException();
        }

        this.start = 0;
        this.end = n - 1;
        this.current = -1;
        this.direction = 1;
	}
	
	/**
	 * Creates an iterator for the finite sequence [a,a+1,a+2...a+n-1]
	 * @throws IllegalArgumentException if t<s
	 */
	public RangeIterator(int a, int n) {
        // Validate parameters
		if(n <= 0){
            throw new IllegalArgumentException("Range length must be greater than zero");
		}

        this.start = a;
        this.end = a + n - 1;
        this.current = a - 1; // before start
        this.direction = 1;
	}
	
	@Override
	public boolean hasNext() {
        if(current < start){
            return true;
        }

        if (direction == 1) {
            return current < end;
        }
        else {
            return current > start;
        }
    }

	@Override
	public Integer next() {
		if(!hasNext()) {
            throw new NoSuchElementException();
        }

        if(current < start){
            current = start;
        }
        else{
            current += direction;
        }
        return current;
	}
	
	public void reverse() {
		direction *= -1;
	}
}
