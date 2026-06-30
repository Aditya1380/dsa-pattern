package com.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> result = new ArrayList<>();
		int i = 0;
		int n = intervals.length;

		// Phase 1: Add all intervals that come strictly before the new interval
		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i]);
			i++;
		}

		// Phase 2: Merge all overlapping intervals into 'newInterval'
		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		// Add the final merged version of the new interval
		result.add(newInterval);

		// Phase 3: Add all remaining intervals that come strictly after
		while (i < n) {
			result.add(intervals[i]);
			i++;
		}

		// Convert List back to 2D Array
		return result.toArray(new int[result.size()][]);
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 6, 9 } };
		int[] newInterval = { 4, 7 };

		System.out.println("Original: " + Arrays.deepToString(intervals));
		System.out.println("Insert:   " + Arrays.toString(newInterval));

		int[][] result = insert(intervals, newInterval);
		System.out.println("Result:   " + Arrays.deepToString(result));
		// Expected Output: [[1, 5], [6, 9]]
	}
}