package my.problemsolving;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, -2, 1, 2, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[]) {
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;

		for (int i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			System.out.println("i = " + i + ", max_ending_here = " + max_ending_here);
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
		}
		return max_so_far;
	}

}
