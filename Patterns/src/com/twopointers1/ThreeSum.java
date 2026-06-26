package com.twopointers1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static List<List<Integer>> threesumsolution(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int length = nums.length;

		for (int i = 0; i < length - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int left = i + 1;
			int right = length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
					result.add(List.of(nums[i], nums[left], nums[right]));
					left++;
					right--;

					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				}
			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {-4,-1,-1,0,1,2};
		 List<List<Integer>> res =  threesumsolution(nums);
		
		System.out.println(res);
	}
}
