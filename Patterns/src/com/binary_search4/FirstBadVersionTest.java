package com.binary_search4;

//Mocking the LeetCode parent class for local testing
class VersionControl {
	// Let's assume version 4 is the first bad version for our test
	private final int FIRST_BAD_VERSION = 4;

	// The API provided by LeetCode
	public boolean isBadVersion(int version) {
		return version >= FIRST_BAD_VERSION;
	}
}


public class FirstBadVersionTest extends VersionControl {

	public int firstBadVersion(int n) {
		int low = 1;
		int high = n;

		System.out.println("Starting Binary Search within range [1, " + n + "]");
		System.out.println("---------------------------------------------");

		while (low < high) {
			int mid = low + (high - low) / 2;

			System.out.printf("Checking Mid: %d | Current Window: [%d, %d]%n", mid, low, high);

			if (isBadVersion(mid)) {
				System.out.printf("   -> Version %d is BAD. First bad is at mid or to the left.%n", mid);
				high = mid; // Narrow down to left half (including mid)
			} else {
				System.out.printf("   -> Version %d is GOOD. First bad must be to the right.%n", mid);
				low = mid + 1; // Narrow down to right half
			}
		}

		// low and high have met at the first bad version
		System.out.println("---------------------------------------------");
		return low;
	}

	public static void main(String[] args) {
		FirstBadVersionTest tester = new FirstBadVersionTest();

		// Total of 5 versions. (Expected output should be 4 based on our mock setup)
		int totalVersions = 5;

		int result = tester.firstBadVersion(totalVersions);
		System.out.println("SUCCESS: The first bad version found is: " + result);
	}
}