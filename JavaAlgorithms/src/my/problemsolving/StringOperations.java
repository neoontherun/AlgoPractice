package my.problemsolving;

import java.util.Arrays;

public class StringOperations {

	public static String reverseUsingBuiltin(String input) {
		if (input == null || input.isEmpty()) {
			return input;
		}
		return input.charAt(input.length() - 1) + reverseUsingBuiltin(input.substring(0, input.length() - 1));
	}

	public static String reverseUsingNative(String input) {
		// convert x into an arrayj
		char[] string = input.toCharArray();
		// create the StringBuffer object
		StringBuffer buffer = new StringBuffer();
		// iterate from the back of the array, each time adding a character to
		// buffer
		for (int i = string.length - 1; i >= 0; i--) {
			buffer.append(string[i]);
		}
		return buffer.toString();
	}

	/**
	 * Device a iterative method for the same. This is recursive.
	 * 
	 * @param ans
	 * @param remain
	 */
	public static void printAllPermutation(String ans, String remain) {
		int n = remain.length();
		// ans serves as an accumulator variable
		// base case: we print out ans since there are no more letters to be
		// added
		if (n == 0) {
			System.out.println(ans);
		}
		// recursive case
		else {
			for (int i = 0; i < n; i++) {
				// we call permutation, each time combining prefix with the
				// individual letters in str
				// we also remove these letters from str
				printAllPermutation(ans + remain.charAt(i), remain.substring(0, i) + remain.substring(i + 1, n));
			}
		}
	}

	/**
	 * String rotation is can be used for finding substring, equality of
	 * strings.
	 * 
	 * 1- There can be only two cases: a) Clockwise rotated b) Anti-clockwise
	 * rotated
	 * 
	 * 2- If clockwise rotated that means elements are shifted in right. So,
	 * check if a substring[2.... len-1] of string2 when concatenated with
	 * substring[0,1] of string2 is equal to string1. Then, return true.
	 * 
	 * 3- Else, check if it is rotated anti-clockwise that means elements are
	 * shifted to left. So, check if concatenation of substring[len-2, len-1]
	 * with substring[0....len-3] makes it equals to string1. Then return true.
	 * 
	 * 4- Else, return false.
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */

	public static boolean isRotated_UsingNative(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		String clock_rot = "";
		String anticlock_rot = "";
		int len = str2.length();

		// Initialize string as anti-clockwise rotation
		anticlock_rot = anticlock_rot + str2.substring(len - 2, len) + str2.substring(0, len - 2);

		// Initialize string as clock wise rotation
		clock_rot = clock_rot + str2.substring(2) + str2.substring(0, 2);

		// check if any of them is equal to string1
		return (str1.equals(clock_rot) || str1.equals(anticlock_rot));
	}

	public static boolean isRotation_UsingInbuilt(String s1, String s2) {
		return (s1.length() == s2.length()) && ((s1 + s1).indexOf(s2) != -1);
	}

	public static String compressString(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() < 2) {
			return str;
		}
		char[] chars = str.toCharArray();
		int insertIndex = 0;
		int i = 0;
		while (i < chars.length) {
			int j = i + 1;
			int counter = 1;
			while (j < chars.length && chars[j] == chars[i]) {
				i++;
				j++;
				counter++;
			}
			chars[insertIndex] = chars[i];
			if (counter > 1) {
				chars[++insertIndex] = String.valueOf(counter).toCharArray()[0];
			}
			insertIndex++;
			i = j;
		}
		System.out.println(Arrays.toString(chars));
		return new String(chars, 0, insertIndex);
	}

	public static void main(String[] args) {
		// String fullString = "abcdaabbddddccccefeeeee";
		// System.out.println(compressString(fullString));

		// printAllPermutation("", "abcd");

	}
}
