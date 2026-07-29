package com.monotonicstack;

import java.util.Stack;

public class Pattern132 {
	public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2};
        System.out.println("Contains 132 pattern: " + find132pattern(nums)); 
        // Expected Output: true
    }

	private static boolean find132pattern(int[] nums) {
		
		if(nums == null || nums.length < 3) {
			return false;
		}
		
		Stack<Integer> stack =  new Stack<>();
		
		int num3 = Integer.MIN_VALUE;
		
		for(int i = nums.length - 1;i>=0;i--) {
			
			if(nums[i]<num3) {
				return true;
			}
			
			while(!stack.isEmpty() && nums[i] > stack.peek()) {
				num3 = stack.pop();
			}
			stack.push(nums[i]);
			
		}
		
		return false;
	}
}
