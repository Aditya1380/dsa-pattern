package com.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;

		System.out.println("Top " + k + " frequent elements: " + Arrays.toString(topKFrequent(nums, k)));
		// Expected Output: [2, 1] (order does not matter)
	}

	private static int[] topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> freqMap.get(a) - freqMap.get(b));

		for (int num : freqMap.keySet()) {
			minHeap.add(num);

			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}
}
