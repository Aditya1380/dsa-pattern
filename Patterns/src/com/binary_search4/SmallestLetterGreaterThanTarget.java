package com.binary_search4;

public class SmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		char[] letters = { 'c', 'f', 'j' };

		// Test Case 1: Target is 'a' (Smallest greater is 'c')
		System.out.println("Target 'a': " + nextGreatestLetter(letters, 'a')); // Output: c

		// Test Case 2: Target is 'c' (Smallest strictly greater is 'f')
		System.out.println("Target 'c': " + nextGreatestLetter(letters, 'c')); // Output: f

		// Test Case 3: Target is 'd' (Smallest greater is 'f')
		System.out.println("Target 'd': " + nextGreatestLetter(letters, 'd')); // Output: f

		// Test Case 4: Target is 'z' (None greater, wraps around to 'c')
		System.out.println("Target 'z': " + nextGreatestLetter(letters, 'z')); // Output: c
	}

	private static char nextGreatestLetter(char[] letters, char target) {
		int low = 0;
		int high = letters.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (letters[mid] <= target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}
		return letters[low % letters.length];
	}
}
