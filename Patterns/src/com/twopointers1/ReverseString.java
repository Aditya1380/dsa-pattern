package com.twopointers1;

public class ReverseString {

	public static String reversestring(String s) {
		
		char[] ch = s.toCharArray();
		int left=0;
		int right = s.length()-1;
		while(left<right) {
			char temp = ch[left];
			ch[left] = ch[right];
			ch[right] = temp;

			left++;
			right--;
		}
		String rev = new String(ch);
		return rev;
	}

	public static void main(String[] args) {
		String s = "aditya";
		
		System.out.println("reverse of "+ s +" is "+ reversestring(s));
		
	}
}