package com.twopointers1;

public class ValidPalindrome {

	public static boolean checkPalindrome(String s) {

		int left = 0;
		int right = s.length() - 1;

		while(left<right) {
			if(s.charAt(left)!=s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {

		String s = "mam";
		String r = "aabbaa";
		
		System.out.println("String "+ s +" is "+ checkPalindrome(s));
		System.out.println("String "+ r +" is "+ checkPalindrome(r));
	}
}
