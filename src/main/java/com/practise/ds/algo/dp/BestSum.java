package com.practise.ds.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function <b>'bestSum(targetSum, numbers)'</b> that takes in a
 * tarfetSum and an array of numbers as arguments. <br/>
 * The function should return an array containing <b><i>the shortest
 * combination</i></b> of numbers that add up to exactly the targetSum. <br/>
 * If there is a tie for the shortest combination, you may return any of the
 * shortest.<br/>
 * You may use an element of the array as many times as needed. <br/>
 * You may assume that all the input numbers are non-negative. <br/>
 * <br/>
 * <b>Problem Type : <i>Optimization Problem</i></b>
 * <br/><br/>
 * <b>Technique Used :</b>  Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class BestSum {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 5};
		System.out.println(bestSum(8, numbers, new HashMap<>())); // [5, 3]

		numbers = new int[] { 1, 2, 3, 5, 25 };
		//System.out.println(bestSum(100, numbers, new HashMap<>())); // [5, 3]
	}

	private static List<Integer> bestSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {

		if (memo.containsKey(targetSum)) {
			return memo.get(targetSum);
		}
		if (targetSum < 0) {
			return null;
		}
		if (targetSum == 0) {
			return new ArrayList<>();
		}

		List<Integer> shortestCombination = null;
		for (int num : numbers) {
			List<Integer> list = bestSum(targetSum - num, numbers, memo);
			if (list != null) {
				list.add(num);
				if (shortestCombination == null || shortestCombination.size() > list.size()) {
					shortestCombination = list;
				}
			}
		}

		memo.put(targetSum, shortestCombination);
		return shortestCombination;
	}

}
