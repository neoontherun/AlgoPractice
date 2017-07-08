package my.problemsolving;

import java.util.Arrays;

/*
	Replace element of an Array with nearest bigger number at right side of the Array in O(n) 
	For example if the input Array is 
	7, 5, 6, 3, 4, 1, 2, 9, 11 
	output array should be 
	9, 6, 9, 4, 9, 2, 9, 11, 11
	
 */
public class ReplaceNearestBiggerNumber {
	
	public static void main(String[] args) {
		int arr[] = {7, 5, 6, 3, 4, 1, 2, 9, 11};
		System.out.println("Initial : " + Arrays.toString(arr));
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			counter++;
			int j = i + 1;
			while (j < arr.length) {
				counter++;
				if (arr[i] < arr[j]) {
					arr[i] = arr[j];
					break;
				}
				j++;
			}
		}
		System.out.println("Replaced : " + Arrays.toString(arr));
		System.out.println("Counter : " + counter);
	}

}
