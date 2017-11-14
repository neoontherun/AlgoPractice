package my.sorting;

import java.util.Arrays;

public class InsertionSort {

	public void sort(int a[]) {
		int size = a.length;
		for (int i = 1; i < size; i++) {
			int j = i - 1;
			int key = a[i];
			System.out.println("Key : " + key);
			System.out.println("a[" + j + "] = " + a[j] + ", a[" + (j + 1) + "] = " + a[j + 1]);
			while (j >= 0 && a[j] > key) {
				// this is shifting of array to make way for key to be inserted in the right place.
				a[j + 1] = a[j];
				j--;
				System.out.println("Sorting..." + Arrays.toString(a));
			}
			a[j + 1] = key;
			System.out.println("Interim Sort : " + Arrays.toString(a));
		}
	}

	public static void main(String args[]) {
		// int arr[] = { 9, 7, 6, 15, 16, 5, 10, 11 };
		int arr[] = { 12, 9, 7, 5, 3 };
		// int arr[] = { 3, 5, 7, 9, 12 };
		System.out.println("Unsorted Arr : " + Arrays.toString(arr));
		InsertionSort ob = new InsertionSort();
		ob.sort(arr);
		System.out.println("Sorted Array : " + Arrays.toString(arr));
	}
}
