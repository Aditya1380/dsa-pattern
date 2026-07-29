package com.monotonicstack;

import java.util.*;

public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the pre-calculated answers: <Element, Next Greater Element>
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Step 1: Process the main array nums2 using a Monotonic Stack
        for (int num : nums2) {
            // WHILE stack isn't empty AND current number is greater than the top of stack
            while (!stack.isEmpty() && num > stack.peek()) {
                // Pop the smaller number out—its next greater element is the current 'num'!
                map.put(stack.pop(), num);
            }
            // Push the current number onto the stack to wait for its match
            stack.push(num);
        }

        // Step 2: Build the output array for nums1 using our lookup map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If the number exists in our map, grab its answer. Otherwise, return -1.
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = nextGreaterElement(nums1, nums2);
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
        // Expected Output: [-1, 3, -1]
    }
}