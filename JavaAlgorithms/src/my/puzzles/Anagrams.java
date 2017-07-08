package my.puzzles;

import java.util.Arrays;

public class Anagrams {

	public static boolean anagrams(String s, String t) {
		if (s.length() != t.length())
			return false;

		int[] cmap = new int[256];
		for (int i = 0; i < cmap.length; ++i) {
			cmap[i] = 0;
		}

		int numOfBin = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (cmap[s.charAt(i)] == 0)
				numOfBin++;
			cmap[s.charAt(i)]++;
		}

		for (int i = 0; i < t.length(); ++i) {
			cmap[t.charAt(i)]--;
			if (cmap[t.charAt(i)] < 0) {
				return false;
			} else if (cmap[t.charAt(i)] == 0) {
				numOfBin--;
			}
		}
		return numOfBin == 0 ? true : false;
	}

	/**
	 * Simpler Implementation. O(nlogn)
	 * 
	 * @param firstWord
	 * @param secondWord
	 * @return
	 */
	public static boolean isAnagram(String firstWord, String secondWord) {
		if (firstWord != null && secondWord != null && firstWord.length() == secondWord.length()) {
			char[] word1 = firstWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
			char[] word2 = secondWord.toLowerCase().replaceAll("[\\s]", "").toCharArray();
			Arrays.sort(word1);
			Arrays.sort(word2);
			return Arrays.equals(word1, word2);
		} else {
			return false;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(anagrams("abcde", "abedc"));
		// System.out.println(anagrams("ababab", "baaabb"));
		// System.out.println(anagrams("aaaa", "aaaa"));

		System.out.println(anagrams("abcde", "abgdc"));
		System.out.println(isAnagram("abcde", "abgdc"));

		System.out.println(isAnagram("abcde", "abedc"));
		System.out.println(isAnagram("ababab", "Baaabb"));
		System.out.println(isAnagram("aaaa", "aaaa"));
	}

}