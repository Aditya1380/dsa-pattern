package com.heap;

import java.util.PriorityQueue;

public class KthLargerstElementInArray {

	public static void main(String[] args) {
        int[] nums = {5, 2, 1, 3, 6, 4};
        int k = 2;

        System.out.println(k + "nd largest element: " + findKthLargest(nums, k));
        // Expected Output: 5
    }

	private static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minheap = new PriorityQueue<Integer>();
		
		for(int num:nums) {
			minheap.add(num);
			if(minheap.size()>k) {
				minheap.poll();
			}
		}
		return minheap.peek();
	}
}
