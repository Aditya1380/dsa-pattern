package com.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {
	public static void main(String[] args) {
		int[][] A = { { 0, 2 }, { 5, 10 } };
		int[][] B = { { 1, 5 }, { 8, 12 } };

		int[][] result = intervalIntersection(A, B);
		System.out.println("Intersections: " + Arrays.deepToString(result));
		// Expected Output: [[1, 2], [5, 5], [8, 10]]
	}

	private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> result = new ArrayList<int[]>();
		int i = 0;
		int j = 0;

		while (i < firstList.length && j < secondList.length) {
			int start = Math.max(firstList[i][0], secondList[j][0]);
			int end = Math.min(firstList[i][1], secondList[j][1]);

			if (start <= end) {
				result.add(new int[] { start, end });
			}

			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		return result.toArray(new int[result.size()][]);
	}
}
