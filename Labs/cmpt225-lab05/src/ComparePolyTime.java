import java.time.*;

public class ComparePolyTime {

	public static void linearTime(int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += i;
		}
		System.out.println("1+2+3+...+n = " + sum);

	}

	public static void quadraticTime(int n) {
		long sum = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++)
				sum += 1;
		}
		System.out.println("1+2+3+...+n = " + sum);
	}

	public static void cubicTime(int n) {
		long sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					sum += 1;
		}
		System.out.println("n^3 = " + sum);
	}

	public static void countPrimesUpTo(int n) {
		// Using sieve of Eratosthenes to count number of primes less than or equal to n
		boolean[] is_prime = new boolean[n + 1];
		for(int i = 2; i <= n; ++i) {
			is_prime[i] = true;
		}

		int cnt = 0;
		for(int x = 2; x <= n; ++x) {
			if(is_prime[x] == true) {
				cnt += 1;
			}
			for(int y = 2*x; y <= n; y += x) { // you could also move this for loop into the if statement
				is_prime[y] = false;
			}
		}
		System.out.println("There are " + cnt + " primes less than or equal to " + n);
	}

	public static void main(String[] args) {

		int n = 1000;
		long start1 = System.currentTimeMillis();
		linearTime(n);
		long end1 = System.currentTimeMillis();
		System.out.println("linear Time Elapsed Time in milliseconds: " + (end1 - start1) + "\n");

		long start2 = System.currentTimeMillis();
		quadraticTime(n);
		long end2 = System.currentTimeMillis();
		System.out.println("quadratic Time Elapsed Time in milliseconds: " + (end2 - start2) + "\n");

		long start3 = System.currentTimeMillis();
		cubicTime(n);
		long end3 = System.currentTimeMillis();
		System.out.println("cubic Time Elapsed Time in milliseconds: " + (end3-start3) + "\n");

		int m = 10000000;
		long start4 = System.currentTimeMillis();
		countPrimesUpTo(m); // Two nested loops, by still fast on input 10^7
		long end4 = System.currentTimeMillis();
		System.out.println("countPrimes Time Elapsed Time in milliseconds: " + (end4-start4) + "\n");
	}
}
