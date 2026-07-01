package com.mergeintervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
	public static void main(String[] args) {
		// Case 1: [1,2] and [2,3] are fine. [1,3] overlaps with both. Erase [1,3].
		int[][] intervals1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println("Intervals to remove (Case 1): " + eraseOverlapIntervals(intervals1)); // Output: 1

		// Case 2: All identical intervals. Must remove 2 of them.
		int[][] intervals2 = { { 1, 2 }, { 1, 2 }, { 1, 2 } };
		System.out.println("Intervals to remove (Case 2): " + eraseOverlapIntervals(intervals2)); // Output: 2
	}

	private static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return 0;
		}

		Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

		System.out.println("sorted Arrays");
		System.out.println(Arrays.deepToString(intervals));
		
		int lastEnd = intervals[0][1];
		int eraseCount = 0;

		for (int i = 1; i < intervals.length; i++) {
			int nextStart = intervals[i][0];
			int nextEnd = intervals[i][1];
			
			if(nextStart<lastEnd) {
				eraseCount++;
			}else {
				lastEnd = nextEnd;
			}
		}

		return eraseCount;
	}
}
