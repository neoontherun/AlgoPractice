package my.hackerrank;

/**
 * Given five positive integers, find the minimum and maximum values that can be
 * calculated by summing exactly four of the five integers. Then print the
 * respective minimum and maximum values as a single line of two space-separated
 * long integers.
 * 
 * For example, {1,3,5,7,9} . Our minimum sum is 1+3+5+7 and our maximum sum is
 * 3+5+7+9. We would print 16 24
 */

public class MinMaxSum {

	static void miniMaxSum(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		long sum = 0;

		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i];

			if (curr > max) {
				max = curr;
			}
			if (curr < min) {
				min = curr;
			}
			sum += curr;
		}
		System.out.print(sum - max);
		System.out.println(" " + (sum - min));
	}

	public static void main(String[] args) {
	}

}
