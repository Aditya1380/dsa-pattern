package com.slidingwindow2;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinct {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		if (s == null || s.length() == 0 || k <= 0) {
			return 0;
		}

		Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
		int leftPointer = 0;

		char[] characters = s.toCharArray();

		for (char currentChar : characters) {
			charFrequency.merge(currentChar, 1, Integer::sum);
			if (charFrequency.size() > k) {
				char leftChar = characters[leftPointer];
				if (charFrequency.merge(leftChar, -1, Integer::sum) == 0) {
					charFrequency.remove(leftChar);
				}
				leftPointer++;
			}
		}

		return characters.length - leftPointer;
	}

	public static void main(String[] args) {
		System.out.println("Length of longest substring: " + lengthOfLongestSubstringKDistinct("araaci", 2)); // Output: 4 ("araa")
        System.out.println("Length of longest substring: " + lengthOfLongestSubstringKDistinct("araaci", 1)); // Output: 2 ("aa")
        System.out.println("Length of longest substring: " + lengthOfLongestSubstringKDistinct("cbbebi", 3)); // Output: 5 ("cbbeb")
	}
}
