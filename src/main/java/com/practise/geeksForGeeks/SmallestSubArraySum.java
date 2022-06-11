package com.practise.geeksForGeeks;

/**
 * 
 * 
 * Smallest sub-array with sum greater than a given value Difficulty Level :
 * Medium Given an array of integers and a number x, find the smallest sub-array
 * with sum greater than the given value.
 * 
 * @author Sanjeev Kumar
 *
 */
public class SmallestSubArraySum {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 4, 45, 6, 10, 19 };
		System.out.println(smallestSubWithSum(arr, 51));        // 3
		System.out.println("################################################");

		arr = new int[] { 1, 10, 5, 2, 7 };
		System.out.println(smallestSubWithSum(arr, 9));         // 1
		System.out.println("################################################");

		arr = new int[] { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 };
		System.out.println(smallestSubWithSum(arr, 280));        // 4
		System.out.println("################################################");
	}

	private static String smallestSubWithSum(int[] arr, int x) {
		int length = arr.length;
		
		int subLength = 0, sum = 0;
		
		for(int i = 0; i < length; i++) {
			
			int count = i;
			while(sum < x && count < length) {
				System.out.println(count);
				sum += arr[count];
				count++;
			}
			System.out.println("--------------------------------");
			if(sum > x) {
				subLength = count - i;
			}
			
			sum = 0;
		}
		

		return subLength == 0 ? "Not Possible" : String.valueOf(subLength);
	}
}
