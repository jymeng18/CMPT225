package integeriterators;

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
            throw new IllegalArgumentException();
		}

        this.start = a;
        this.end = a + n - 1;
        this.current = a - 1;
        this.direction = 1;
	}
	
	@Override
	public boolean hasNext() {
        if (direction == 1) {
            return (current + 1) <= end;
        }
        else {
            return (current - 1) >= start;
        }
    }

	@Override
	public Integer next() {
		if(hasNext()) {
            current += direction;
            return current;
        }
		return -1;
	}
	
	public void reverse() {
		direction *= -1;

        // Edge case: user reverses at the beginning
        if(current == start && direction == -1){
            current = end;
        }
        else if(current == end && direction == 1) {
            current = start;
        }
	}
}
