package com.twopointers1;



public class SortedSquares {

	public static int[] squares(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		int[] result = new int[nums.length];
		int pos = nums.length-1;
		
		while(left<right) {
			int leftSquare = nums[left] * nums[left];
			int rightSquare = nums[right] * nums[right];
			
			if(leftSquare > rightSquare) {
				result[pos] = leftSquare;
				left++;
			}else {
				result[pos] = rightSquare;
				right--;
			}
			pos--;
		}		
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {-2,-1,0,2,3,5,6,7,8};

		int[] result = squares(nums);
		for(int num : result) {
			System.out.print(num+" ");
		}
	}
}
