package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
	public static void main(String[] args) {
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println("Last stone weight: " + lastStoneWeight(stones));
		// Expected Output: 1
	}

	private static int lastStoneWeight(int[] stones) {

		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int stone : stones) {
			maxHeap.add(stone);
		}

		while (maxHeap.size() > 1) {
			int y = maxHeap.poll();
			int x = maxHeap.poll();

			if (y != x) {
				maxHeap.add(y - x);
			}
		}
		return maxHeap.isEmpty() ? 0 : maxHeap.peek();
	}
}
