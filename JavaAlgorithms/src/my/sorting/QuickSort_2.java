package my.sorting;

import java.util.Arrays;

public class QuickSort_2 {
	int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		// int pivot = arr[(left + right) / 2];
		int pivot = arr[right];

		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		return i;
	}

	void sort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			sort(arr, left, index - 1);
		if (index < right)
			sort(arr, index, right);
	}

	public static void main(String args[]) {
		// int arr[] = { 10, 7, 8, 9, 1, 5 };
		int arr[] = { 9, 7, 6, 15, 16, 5, 10, 11 };
		System.out.println("unsorted array : " + Arrays.toString(arr));
		int n = arr.length;

		QuickSort_2 ob = new QuickSort_2();
		ob.sort(arr, 0, n - 1);

		System.out.println("sorted array : " + Arrays.toString(arr));
	}
}
