package integeriterators;

import java.util.NoSuchElementException;

public class PrimeNumbersIterator implements IntegerIterator {

    private int direction;
    private int current;

    /**
     * Creates an iterator for prime numbers 2,3,5,7,11,13...
     */
	public PrimeNumbersIterator() {
        this.current = 1; // so first call to next() gives 2
        this.direction = 1;
	}

    /**
     * Creates an iterator for prime numbers starting from the n'th prime
     */
	public PrimeNumbersIterator(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("n must be > 0");
        }
        this.current = 1;
        this.direction = 1;

        // Get the nth prime, must be n-1 because test driver calls next() too
        for(int i = 0; i < n - 1; i++){
            next();
        }
	}

    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }

        // Check for divisibility
        for(int i = 2; i * i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        // No divisors found, must be prime
        return true;
    }
	
	@Override
	public boolean hasNext() {

        // There are infinite # of primes forward
		if(direction == 1){
            return true;
        }
        // For reverse direction
        else{
            return current > 2;
        }
	}
	
	@Override
	public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // no elements (will only happen on reverse)
        }
        while (true) {
            current += direction;
            if (isPrime(current)) {
                return current;
            }
        }
    }

	public void reverse() {
		direction *= -1;
	}

}
