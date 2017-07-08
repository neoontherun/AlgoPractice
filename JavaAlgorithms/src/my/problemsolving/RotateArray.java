package my.problemsolving;

import java.util.Arrays;

class RotateArray {
	/* Function to left rotate arr[] of size n by d */
	void leftRotate(int arr[], int d) {
		for (int i = 0; i < d; i++) {
			int temp = arr[0];
			int j = 0;
			for (; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[j] = temp;
		}
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		RotateArray rotate = new RotateArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Before Rotation : " + Arrays.toString(arr));
		rotate.leftRotate(arr, 3);
		System.out.println("Rotated Array : " + Arrays.toString(arr));
	}
}