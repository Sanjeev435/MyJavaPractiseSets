package com.practise.hacker;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Dynamic Programming</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 *         <b>Problem Solving : Intermediate</b></br>
 * @see <a href= "https://www.hackerrank.com/challenges/max-array-sum"> Max
 *      Array Sum </a>
 *
 */
public class MaxSubsetSum {

	public static void main(String[] args) {
		System.out.println(maxSubsetSum(new int[] { 3, 7, 4, 6, 5 }));    // 13
		System.out.println(maxSubsetSum(new int[] { -2, 1, 3, -4, 5 }));  // 8
		System.out.println(maxSubsetSum(new int[] { 3, 5, -7, 8, 10 }));  // 15
		System.out.println(maxSubsetSum(new int[] { 2, 1, 5, 8, 4 }));    // 11
	}

	/**
	 * Using Tabulation technique
	 * 
	 * @param arr
	 * @return
	 */
	private static int maxSubsetSum(int[] arr) {
		
		// Base case : if length is 0
		if (arr.length == 0) {
			return 0;
		}
		
		// Base case : if length is 1
		if (arr.length == 1) {
			return arr[0];
		}
		
		// Base case : if length is 2
		if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		}

		// Base case : check between 0 & 1 index, and assign 1 index with bigger one
		arr[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			arr[i] = Math.max(arr[i], Math.max(arr[i] + arr[i - 2], arr[i - 1]));
		}
		return arr[arr.length - 1];

	}

}
