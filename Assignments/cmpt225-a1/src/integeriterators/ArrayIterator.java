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
        this.ar = ar;
	}

	@Override
	public boolean hasNext() {
        if(direction == 1){
            return (iterator + 1) < ar.length; // Forwards direction
        }
        else{
            return (iterator - 1) >= 0; // Backwards direction
        }
	}
	
	@Override
	public Integer next() {
		if(hasNext()){
            iterator += direction;
            return ar[iterator];
        }
		throw new NoSuchElementException();
	}
	
	public void reverse() {
        if (direction == 1) {
            direction = -1;
        }
        else{
            direction = 1;
        }

        // User reverses before calling next()
        if(iterator == -1 && direction == -1){
            iterator = ar.length;
        }

        // Handles user reverses multiple times before calling next()
        else if(iterator == ar.length && direction == 1){
            iterator = -1;
        }
    }
}
