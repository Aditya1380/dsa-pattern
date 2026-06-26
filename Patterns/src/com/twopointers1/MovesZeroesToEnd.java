package com.twopointers1;

public class MovesZeroesToEnd {

	public static void movezeroes(int[] arr) {
		int insertpos = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[insertpos] = arr[i];
				insertpos++;
			}
		}

		while (insertpos < arr.length) {
			arr[insertpos] = 0;
			insertpos++;
		}

	}

	public static void main(String[] args) {

		int[] arr = {0,1,2,4,0,4,6,0,1,4,2};
		movezeroes(arr);
		
		System.out.println(java.util.Arrays.toString(arr)); 
//		for(int a: arr) {
//			System.out.print(a +" ");
//		}
	}
}
