package com.monotonicstack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Pre-fill the array with -1. 
        // If a number is the absolute maximum in the array, it will never find a greater element and remain -1.
        Arrays.fill(result, -1);

        // Stack stores INDICES, not values
        Stack<Integer> stack = new Stack<>();

        // Run the loop for exactly TWICE the length of the array
        for (int i = 0; i < 2 * n; i++) {
            // The modulo operator safely wraps our pointer around the array
            int currentIndex = i % n;

            // Standard Monotonic Stack Trigger Rule
            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = nums[currentIndex];
            }

            // Optimization: We only need to push indices onto the stack during the FIRST pass.
            // By the second pass, every element has already been evaluated as a starting point.
            if (i < n) {
                stack.push(currentIndex);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        int[] result = nextGreaterElements(nums);

        System.out.println("Next Greater Elements (Circular): " + Arrays.toString(result));
        // Expected Output: [2, -1, 2]
    }
}