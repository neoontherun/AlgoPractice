package my.sorting;

import java.util.Arrays;

public class QuickSort {
	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	int partition(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++) {
			// If current element is smaller than or equal to pivot
			System.out.println("Found arr[" + j + "] = " + arr[j] + " <= pivot(" + pivot + ") to be : " + (arr[j] <= pivot));
			if (arr[j] <= pivot) {
				// In this we keep pushing all the elements less than pivot to the left side of partition.
				i++;
				 System.out.println("Value of i = " + i + " j = " + j);
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			System.out.println("After swaps : " + Arrays.toString(arr));
		}
		//System.out.println("Just before high value swaps : " + Arrays.toString(arr));

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		System.out.println("After high value swaps : " + Arrays.toString(arr));
		System.out.println();
		return i + 1;
	}

	/*
	 * The main function that implements QuickSort() arr[] --> Array to be
	 * sorted, low --> Starting index, high --> Ending index
	 */
	void sort(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi is partitioning index, arr[pi] is now at right place
			 */
			int pi = partition(arr, low, high);
			System.out.println("partition value : " + pi + ", arr[" + pi + "] = " + arr[pi]);
			System.out.println("Interim sorted : " + Arrays.toString(arr));
			// Recursively sort elements before
			// partition and after partition
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}

	// Driver program
	public static void main(String args[]) {
		// int arr[] = { 10, 7, 8, 9, 1, 5 };
		int arr[] = { 9, 7, 6, 15, 16, 5, 10, 11 };
		System.out.println("unsorted array : " + Arrays.toString(arr));
		int n = arr.length;
		QuickSort ob = new QuickSort();
		ob.sort(arr, 0, n - 1);
		System.out.println("sorted array : " + Arrays.toString(arr));
	}
}