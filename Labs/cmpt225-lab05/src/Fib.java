public class Fib {

	public static long fib(int n) {
		if (n <= 1) {
			return n;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static long fibFast(int n) {
		if (n <= 1)
			return n;
		// TODO implement me
		return -1;
	}

	public static void main(String[] args) {
		// Try it for different values of n: 10, 20, 30, 42, 45, 50, 80
		int n = 45;

		long start1 = System.currentTimeMillis();
		long fn = fib(n);
		System.out.println("Fib(" + n + ") = " + fn);
		long end1 = System.currentTimeMillis();
		System.out.println("fib Time Elapsed Time in milliseconds: " + (end1 - start1) + "\n");

		long start2 = System.currentTimeMillis();
		fn = fibFast(n);
		System.out.println("Fib(" + n + ") = " + fn);
		long end2 = System.currentTimeMillis();
		System.out.println("fibFast Time Elapsed Time in milliseconds: " + (end2 - start2) + "\n");

	}
}
