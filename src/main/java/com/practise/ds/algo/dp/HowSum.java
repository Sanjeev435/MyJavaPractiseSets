package com.practise.ds.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function <b>howSum</b> that takes in a targetSum and an array of
 * numbers as arguments. <br/>
 * The function should return an array consisting any combination of elements
 * that add up to exactly the targetSum. If there is no combination that adds up
 * to the targetSum, then return null. <br/>
 * If there are multiple combinations possible, you may return any single one.
 * <br/><br/>
 * <b>Problem Type : <i>Combinatoric Problem</i></b>
 * <br/><br/>
 * <b>Technique Used :</b>  Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class HowSum {

	public static void main(String[] args) {

		int[] numbers = new int[] { 2, 3, 5 };
		System.out.println(howSum(8, numbers, new HashMap<>())); // [2, 2, 2, 2]
		
		numbers = new int[] { 14, 13, 18, 16, 29 };
		System.out.println(howSum(300, numbers, new HashMap<>())); // [series of 16, 18 & 14]

		numbers = new int[] { 2, 3, 5, 8 };
		System.out.println(howSum(15, numbers, new HashMap<>())); // [3, 2, 2, 2, 2, 2, 2]

		numbers = new int[] { 5, 3, 4, 7 };
		System.out.println(howSum(7, numbers, new HashMap<>())); // [4, 3]

		numbers = new int[] { 2, 4 };
		System.out.println(howSum(7, numbers, new HashMap<>())); // null

		numbers = new int[] { 3, 3, 5, 8 };
		System.out.println(howSum(7, numbers, new HashMap<>())); // null

		numbers = new int[] { 7, 14 };
		System.out.println(howSum(300, numbers, new HashMap<>())); // null
	}

	
	/**
	 * Using recursion with memoization
	 * 
	 * @param targetSum       : Target sum which sum need to be searched
	 * @param numbers         : array if input numbers
	 * @param memo            : memo object, preferred map since array will have unused cells
	 * @return List<Integer>  : List if integers whose sum equal to target sum otherwise null
	 */
	private static List<Integer> howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {

		// Memo : check if data is there in memo
		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}

		// Base case : true if targetSum becomes positive
		if (targetSum == 0) {
			return new ArrayList<>();
		}

		// Base case : false if tagetSum becomes negative
		if (targetSum < 0) {
			return null;
		}

		// Since the numbers in array can be repeated, hence loop.
		for (int n : numbers) {
			int num = targetSum - n;
			// Keep subtracting numbers from array with targetSum, so that 0 will
			// be the result for targetSum
			List<Integer> list = howSum(num, numbers, memo);

			if (list != null) {
				list.add(n);
				memo.put(targetSum, list);
				return list;
			}
		}

		memo.put(targetSum, null);
		return null;
	}

}
