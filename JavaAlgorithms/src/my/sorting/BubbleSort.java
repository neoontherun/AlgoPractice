package my.sorting;

import java.util.Arrays;

public class BubbleSort {

	public void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 9, 7, 6, 15, 16, 5, 10, 11 };
		System.out.println("Unsorted Arr : " + Arrays.toString(arr));
		BubbleSort ob = new BubbleSort();
		ob.sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
}
