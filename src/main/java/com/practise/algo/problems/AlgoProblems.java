package com.practise.algo.problems;

import java.util.HashMap;
import java.util.Map;

public class AlgoProblems {

	/**
	 * 
	 * <b>Determine if the sum of two integers is equal to the given value</b><br/>
	 * 
	 * Given an array of integers and a value, determine if there are any two
	 * integers in the array whose sum is equal to the given value. Return true if
	 * the sum exists and return false if it does not.
	 * 
	 * @param numArray
	 * @param sum
	 * @return boolean
	 */
	public boolean checkIfSumExist(int[] numArray, int sum) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : numArray) {
			if (map.containsKey(sum - num)) {
				return true;
			} else {
				map.put(num, num);
			}
		}

		return false;
	}

}
