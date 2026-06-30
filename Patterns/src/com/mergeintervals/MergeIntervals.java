package com.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static void main(String[] args) {
		int[][] intervals = { { 2, 4 }, { 1, 3 }, { 8, 10 }, { 15, 18 }, { 2, 6 } };

		System.out.println("Original: " + Arrays.deepToString(intervals));

		int[][] result = merge(intervals);

		System.out.println("Merged:   " + Arrays.deepToString(result));
		// Expected Output: [[1, 6], [8, 10], [15, 18]]
	}

	private static int[][] merge(int[][] intervals) {

		if (intervals.length <= 1) {
			return intervals;
		}
		// {[1,3],[2,4],[2,6],[8,10],[15,18]}
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

		List<int[]> mergedList = new ArrayList<int[]>();

		int[] currentInterval = intervals[0];
		mergedList.add(currentInterval);

		for (int[] nextInterval : intervals) {
			int currentEnd = currentInterval[1];
			int nextStart = nextInterval[0];
			int nextEnd = nextInterval[1];

			if (nextStart <= currentEnd) {
				currentInterval[1] = Math.max(currentEnd, nextEnd);
			}else {
				currentInterval = nextInterval;
				mergedList.add(currentInterval);
			}

		}

		return mergedList.toArray(new int[mergedList.size()][]);
	}
}
