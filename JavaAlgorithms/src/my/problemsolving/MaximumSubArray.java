package my.problemsolving;

public class MaximumSubArray {

	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, -2, 1, 2, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[]) {
		int maxSum = Integer.MIN_VALUE;
		int sumTillNow = 0;

		for (int i = 0; i < a.length; i++) {
			sumTillNow += a[i];
			System.out.println("i = " + i + ", sumTillNow = " + sumTillNow);
			if (sumTillNow < 0) {
				sumTillNow = 0;
			}
			if (sumTillNow > maxSum) {
				maxSum = sumTillNow;
			}
		}
		return maxSum;
	}

}
