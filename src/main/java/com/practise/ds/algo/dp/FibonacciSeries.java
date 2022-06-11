package com.practise.ds.algo.dp;

/**
 * 
 * <b>Calculate fibonacci element at nth position</b> <br/>
 * <br/>
 * <b>Technique Used :</b> Recursion with memoization<br/>
 * <b>Technique Used :</b> Tabulation
 * 
 * @author Sanjeev Kumar
 *
 */
public class FibonacciSeries {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(getFibonacciSum(n, new Long[n + 1])); // 5
		
		n = 10;
		System.out.println(getFibonacciSum(n, new Long[n + 1])); // 55
		
		n = 20;
		System.out.println(getFibonacciSum(n, new Long[n + 1])); // 6765
		
		n = 50;
		System.out.println(getFibonacciSum(n, new Long[n + 1])); // 12586269025
		
		n = 5;
		System.out.println(getFibonacciSum(n)); // 5

		n = 10;
		System.out.println(getFibonacciSum(n)); // 55

		n = 20;
		System.out.println(getFibonacciSum(n)); // 6765

		n = 50;
		System.out.println(getFibonacciSum(n)); // 12586269025
		 
	}

	/**
	 * Using recursion with memoization
	 * 
	 * @param n    : number unto which sum need to be calculated
	 * @param arr  : Long type array use for memoization. Integer range issue, hence long
	 * @return     : Return sum of series
	 */
	private static Long getFibonacciSum(int n, Long[] memo) {

		// Get memo data from array
		if (memo[n] != null) {
			return memo[n];
		}

		// Base case : for 1 & 2, fibonacci series will always be 1
		if (n <= 2) {
			return 1L;
		}
		
		// Insert data in memo array and return the data
		memo[n] = getFibonacciSum(n - 1, memo) + getFibonacciSum(n - 2, memo);
		return memo[n];

	}
	
	/**
	 * Using tabulation technique of dynamic programming
	 * 
	 * @param n    : number unto which sum need to be calculated
	 * @return     : Return sum of series
	 */
	private static Long getFibonacciSum(int n) {

		long[] fibSeries = new long[n + 1];

		fibSeries[1] = 1L;

		for (int i = 0; i < n; i++) {
			fibSeries[i + 1] += fibSeries[i];
			if (i + 2 < n + 1) {
				fibSeries[i + 2] += fibSeries[i];
			}
		}

		return fibSeries[n];
	}

}
