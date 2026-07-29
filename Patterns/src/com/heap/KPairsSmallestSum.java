package com.heap;

import java.util.*;

public class KPairsSmallestSum {

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return result;
		}

		// Min-Heap storing triples: {sum, indexInNums1, indexInNums2}
		// Ordered strictly by pair sum in ascending order
		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		// Step 1: Initialize heap with first min(k, nums1.length) elements from nums1
		// paired with nums2[0]
		for (int i = 0; i < Math.min(k, nums1.length); i++) {
			minHeap.offer(new int[] { nums1[i] + nums2[0], i, 0 });
		}

		// Step 2: Extract smallest pair and advance the pointer in nums2
		while (!minHeap.isEmpty() && result.size() < k) {
			int[] current = minHeap.poll();
			int i = current[1];
			int j = current[2];

			// Add valid pair to result list
			result.add(Arrays.asList(nums1[i], nums2[j]));

			// If there's a next element in nums2, push (nums1[i], nums2[j + 1]) to the heap
			if (j + 1 < nums2.length) {
				minHeap.offer(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 7, 11 };
		int[] nums2 = { 2, 4, 6 };
		int k = 3;

		System.out.println("K smallest pairs: " + kSmallestPairs(nums1, nums2, k));
		// Expected Output: [[1, 2], [1, 4], [1, 6]]
	}
}