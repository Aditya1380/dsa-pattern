package com.cyclicsort3;

import java.util.Arrays;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int i = 0;
        int n = nums.length;

        // Step 1: Cyclic Sort
        while (i < n) {
            int correctIndex = nums[i] - 1;

            // Swap if the number is not at its correct index
            // And ensure we don't swap with an identical number (prevents infinite loop)
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find the mismatch
        // The index that doesn't match its value tells us both numbers
        for (int index = 0; index < n; index++) {
            if (nums[index] != index + 1) {
                // The value currently sitting here is the duplicate
                // The value that SHOULD have been here (index + 1) is the missing number
                return new int[] { nums[index], index + 1 };
            }
        }

        return new int[] {-1, -1}; // Fallback
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4}; // 2 is duplicated, 3 is missing
        int[] result = findErrorNums(nums);
        System.out.println("Result [Duplicate, Missing]: " + Arrays.toString(result)); 
        // Output: [2, 3]
    }
}