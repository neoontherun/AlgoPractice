package my.problemsolving;

public class Factorial {

	public int fact_recursive(int i) {
		if (i <= 1) {
			return 1;
		}
		return i * fact_recursive(i - 1);
	}
	
	public int fact_iterative(int n) {
		if (n <= 1) {
			return 1;
		}
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	public static void main(String[] args) {
		System.out.println(new Factorial().fact_recursive(5));
		System.out.println(new Factorial().fact_iterative(5));
	}

}
