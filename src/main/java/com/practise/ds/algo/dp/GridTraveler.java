package com.practise.ds.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a traveler on a 2D grid. You begin in the top-left corner and your
 * goal is to travel to the bottom-right corner. You may only move down or
 * right. <br/>
 * In how many ways can you travel to the goal on a grid with dimensions m*n ?
 * <br/>
 * <b>Technique Used :</b> Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class GridTraveler {

	public static void main(String[] args) {
		// Base conditions
		System.out.println(gridTraveler(1, 1, new HashMap<>())); // 1
		System.out.println(gridTraveler(5, 0, new HashMap<>())); // 0
		System.out.println(gridTraveler(0, 6, new HashMap<>())); // 0

		// Complex conditions
		// One thing can be noted that interchanging row and columns will not have any
		// effect on answer
		System.out.println(gridTraveler(3, 2, new HashMap<>()));   // 3
		System.out.println(gridTraveler(2, 3, new HashMap<>()));   // 3
		System.out.println(gridTraveler(6, 5, new HashMap<>()));   // 126
		System.out.println(gridTraveler(5, 6, new HashMap<>()));   // 126
		System.out.println(gridTraveler(10, 12, new HashMap<>())); // 167960
		System.out.println(gridTraveler(20, 20, new HashMap<>())); // 35345263800
	}

	/**
	 * Using recursion with memoization
	 * 
	 * @param n : number of rows
	 * @param m : number of columns
	 * @return : number of ways a traveler can travel to destination
	 */
	private static Long gridTraveler(int n, int m, Map<String, Long> memoData) {
		String key = n + "," + m;

		if (memoData.containsKey(key)) { // Check if data is there in memory, return it
			return memoData.get(key);
		} else if (n == 0 || m == 0) { // When row is zero or column in zero, player can't move anywhere
			return 0L;
		} else if (n == 1 && m == 1) { // Player reached destination, hence 1 move
			return 1L;
		} else {
			// Possible ways from any point is either right or down
			// Right case -> n, m-1 (row constant, column decrease)
			// Down case -> n-1, m (row decrease, column constant)
			memoData.put(key, gridTraveler(n, m - 1, memoData) + gridTraveler(n - 1, m, memoData));
			return memoData.get(key);
		}
	}

}
