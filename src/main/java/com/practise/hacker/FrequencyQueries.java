package com.practise.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Algorithm -> Recursion</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href= "https://www.hackerrank.com/challenges/frequency-queries">
 *      Frequency Queries </a>
 *
 */
public class FrequencyQueries {

	public static void main(String[] args) {
		// [0, 1]
		List<int[]> queries = Arrays.asList(new int[] { 1, 1 }, new int[] { 2, 2 }, new int[] { 3, 2 },
				new int[] { 1, 1 }, new int[] { 1, 1 }, new int[] { 2, 1 }, new int[] { 3, 2 });

		List<Integer> queryFrequency = freqQuery(queries);
		queryFrequency.forEach(System.out::println);

		// [0, 1, 1]
		List<int[]> queries1 = Arrays.asList(new int[] { 1, 3 }, new int[] { 2, 3 }, new int[] { 3, 2 },
				new int[] { 1, 4 }, new int[] { 1, 5 }, new int[] { 1, 5 }, new int[] { 1, 4 }, new int[] { 3, 2 },
				new int[] { 2, 4 }, new int[] { 3, 2 });

		List<Integer> queryFrequency1 = freqQuery(queries1);
		queryFrequency1.forEach(System.out::println);

		// [0, 1]
		List<int[]> queries2 = Arrays.asList(new int[] { 1, 5 }, new int[] { 1, 6 }, new int[] { 3, 2 },
				new int[] { 1, 10 }, new int[] { 1, 10 }, new int[] { 1, 6 }, new int[] { 2, 5 }, new int[] { 3, 2 });

		List<Integer> queryFrequency2 = freqQuery(queries2);
		queryFrequency2.forEach(System.out::println);
	}

	static List<Integer> freqQuery(List<int[]> queries) {

		List<Integer> data = new ArrayList<>();
		Map<Integer, Integer> occurence = new HashMap<>();
		Map<Integer, Integer> valueMap = new HashMap<>();

		for (int[] query : queries) {

			Integer value = query[1];

			switch (query[0]) {

			case 1: {
				Integer occuredValue = occurence.containsKey(value) ? occurence.get(value) : 0;
				incrementForOccurence(valueMap, occuredValue);
				incrementIfPresent(occurence, value);
				break;
			}
			case 2: {
				decrementIfPresent(occurence, valueMap, value);
				break;
			}
			case 3: {
				if (valueMap.containsKey(value) && valueMap.get(value) > 0) {
					data.add(1);
				} else {
					data.add(0);
				}
				break;
			}

			}
		}

		return data;
	}

	private static void decrementIfPresent(Map<Integer, Integer> occurence, Map<Integer, Integer> valueMap,
			Integer value) {
		if (occurence.containsKey(value)) {
			decrementForOccurence(valueMap, occurence.get(value));
			if (occurence.get(value) > 0) {
				occurence.put(value, (occurence.get(value) - 1));
			} else {
				occurence.remove(value);
			}
		}
	}

	private static void incrementIfPresent(Map<Integer, Integer> occurence, Integer value) {
		if (occurence.containsKey(value)) {
			occurence.put(value, (occurence.get(value) + 1));
		} else {
			occurence.put(value, 1);
		}
	}

	private static void incrementForOccurence(Map<Integer, Integer> valueMap, Integer value) {
		if (valueMap.containsKey(value)) {
			if (valueMap.get(value) == 1) {
				valueMap.remove(value);
			} else {
				valueMap.put(value, (valueMap.get(value) - 1));
			}
			valueMap.merge(value + 1, 1, Integer::sum);
		} else {
			valueMap.merge(value + 1, 1, Integer::sum);
		}
	}

	private static void decrementForOccurence(Map<Integer, Integer> valueMap, Integer value) {
		if (valueMap.containsKey(value)) {
			if (valueMap.get(value) == 1) {
				valueMap.remove(value);
			} else {
				valueMap.put(value, (valueMap.get(value) - 1));
			}
			valueMap.merge(value - 1, 1, Integer::sum);
		}
	}

}
