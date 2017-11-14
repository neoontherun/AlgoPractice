package my.problemsolving;

// Java program for Fibonacci Series using Space Optimized Method
class Fibonacci {

	static int fib_iterative(int n) {
		int a = 0, b = 1, c;
		if (n == 0) {
			return a;
		}
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	static int fib_recursive(int n) {
		if (n <= 2) {
			return 1;
		}
		return fib_recursive(n - 1) + fib_recursive(n - 2);
	}

	public static void main(String args[]) {
		int n = 10;
		System.out.println(fib_iterative(n));
		System.out.println(fib_recursive(n));
	}
}