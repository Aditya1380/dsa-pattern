package com.cyclicsort3;

import java.util.ArrayList;
import java.util.List;

public class DisappearedNumbers {

	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> disappearedNumbers = new ArrayList<Integer>();
		int i=0;
		int n = nums.length;
		while (i < n) {
			int correctIndex = nums[i]-1;

			if (nums[i] < n && nums[i] != nums[correctIndex]) {
				swap(nums, i, correctIndex);
			} else {
				i++;
			}
		}

		for (int index = 0; index < nums.length; index++) {
            // If the value at the current index doesn't match index + 1, it's missing
            if (nums[index] != index + 1) {
                disappearedNumbers.add(index + 1);
            }
        }

        return disappearedNumbers;

	}

	private static void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
	
	public static void main(String[] args) {
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

		System.out.println("Disappeared numbers in [4, 3, 2, 7, 8, 2, 3, 1]: " + findDisappearedNumbers(nums));
	}
}
