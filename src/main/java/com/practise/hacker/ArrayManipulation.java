package com.practise.hacker;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Arrays</b> </br>
 *         <b>Problem Difficulty : Hard</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/crush/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays">
 *      Array Manipulation</a>
 *
 */
public class ArrayManipulation {

	public static void main(String[] args) {
		
		// Solution : 200
		System.out.println(arrayManipulation(5, Arrays.asList(
				Arrays.asList(1, 2, 100), 
                Arrays.asList(2, 5, 100), 
                Arrays.asList(3, 4, 100))));
		
		// Solution : 10
		System.out.println(arrayManipulation(10, Arrays.asList(
				Arrays.asList(1, 5, 3), 
				Arrays.asList(4, 8, 7), 
				Arrays.asList(6, 9, 1))));
		
		// Solution : 31
		System.out.println(arrayManipulation(10, Arrays.asList(
				Arrays.asList(2, 6, 8), 
				Arrays.asList(3, 5, 7), 
				Arrays.asList(1, 8, 1),
				Arrays.asList(5, 9, 15))));
	}
	
	/*
	 * Complete the 'arrayManipulation' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
	 */

	public static long arrayManipulation(int n, List<List<Integer>> queries) {

		Integer[] baseArray = new Integer[n + 1];
		Map<Integer, Long> additiveMap = new TreeMap<>();

		for (List<Integer> query : queries) {
			getAdditive(baseArray, additiveMap, (query.get(0) - 1), query.get(2));
			getAdditive(baseArray, additiveMap, query.get(1), -(query.get(2)));
		}

		Long maximumData = 0L;
		Long additionTemp = 0L;
		for (Map.Entry<Integer, Long> additive : additiveMap.entrySet()) {
			additionTemp += additive.getValue();

			if (additionTemp > maximumData) {
				maximumData = additionTemp;
			}
		}

		return maximumData;
	}

	private static void getAdditive(Integer[] baseArray, 
			Map<Integer, Long> additiveMap, Integer position, Integer data) {

		additiveMap.put(position, additiveMap.getOrDefault(position, 0L) + data);

		if (baseArray[position] != null) {
			baseArray[position] = data + baseArray[position];
		} else {
			baseArray[position] = data;
		}
	}

}


