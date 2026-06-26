package com.twopointers1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static List<List<Integer>> foursumsolution(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		int length = nums.length;
		for (int first = 0; first < length - 3; first++) {

			if (first > 0 && nums[first] == nums[first - 1]) {
				continue;
			}

			for (int second = first + 1; second < length - 2; second++) {
				if (second > first + 1 && nums[second] == nums[second - 1]) {
					continue;
				}

				int left = second + 1;
				int right = length - 1;

				while (left < right) {
					int sum = nums[first] + nums[second] + nums[left] + nums[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {

						result.add(List.of(nums[first], nums[second], nums[left], nums[right]));
						left++;
						right--;

						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}

						while (left < right && nums[right] == nums[right + 1]) {
							right--;
						}
					}
				}

			}

		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {-2,-1,0,0,1,2};
		 List<List<Integer>> res =  foursumsolution(nums,0);
		
		System.out.println(res);
	}
}
