package com.practise.ds.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function <b>'canSum(targetSum, numbers)'</b> that takes in a
 * tarfetSum and an array of numbers as arguments. <br/>
 * The function should return a boolean indicating whether or not it is possible
 * to generate the targetSum using numbers from the array. <br/>
 * You may use an element of the array as many times as needed. <br/>
 * You may assume that all the input numbers are non-negative.
 * <br/><br/>
 * <b>Problem Type : <i>Decision Problem</i></b>
 * 
 * @author Sanjeev Kumar
 *
 */
public class CanSum {

	
	public static void main(String[] args) {
		int[] numbers = {1, 5, 3, 8, 6};
		System.out.println(canSum(300, numbers, new HashMap<>()));  // true
		
		numbers = new int[]{2, 3, 5, 8};
		System.out.println(canSum(15, numbers, new HashMap<>()));   // true
		
		numbers = new int[]{5, 3, 4, 7};
		System.out.println(canSum(7, numbers, new HashMap<>()));    // true
		
		numbers = new int[]{2, 4};
		System.out.println(canSum(7, numbers, new HashMap<>()));   // false
		
		numbers = new int[]{3, 3, 5, 8};
		System.out.println(canSum(7, numbers, new HashMap<>()));   // false
		
		numbers = new int[]{7, 14};
		System.out.println(canSum(300, numbers, new HashMap<>())); // false
	}

	/**
	 * Using recursion with memoization
	 * 
	 * @param targetSum : Target sum which sum need to be searched
	 * @param numbers   : array if input numbers
	 * @param memo      : memo object, preferred map since array will have unused cells
	 * @return boolean  : true if sum found otherwise false
	 */
	private static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {

		if (memo.containsKey(targetSum)) { // Memo : check if data is there in memo
			return memo.get(targetSum);
		} else if (targetSum < 0) {        // Base case : false if tagetSum becomes negative
			return false;
		} else if (targetSum == 0) {       // Base case : true if targetSum becomes positive
			return true;
		} else {
			// Since the numbers in array can be repeated, hence loop.
			for (int n : numbers) {

				// Keep subtracting numbers from array with targetSum, so that 0 will
				// be the result for targetSum
				boolean result = canSum(targetSum - n, numbers, memo);

				// Put data in memo
				memo.put(targetSum, result);
				if (result) {
					return true;
				}
			}
		}
		return false;
	}
}
