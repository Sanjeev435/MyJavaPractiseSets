package com.practise.hacker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Data Structure</b> </br>
 *         <b>Problem Difficulty : Easy</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/one-week-preparation-kit-countingsort1">
 *      Bigger is greater </a>
 *
 */
public class CountingSort {

	public static void main(String[] args) {

		List<Integer> data = Arrays.asList(63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67,
				99, 12, 83, 89, 80, 91, 39, 86, 76, 85, 74, 39, 25, 90, 59, 10, 94, 32, 44, 3, 89, 30, 27, 79, 46, 96,
				27, 32, 18, 21, 92, 69, 81, 40, 40, 34, 68, 78, 24, 87, 42, 69, 23, 41, 78, 22, 6, 90, 99, 89, 50, 30,
				20, 1, 43, 3, 70, 95, 33, 46, 44, 9, 69, 48, 33, 60, 65, 16, 82, 67, 61, 32, 21, 79, 75, 75, 13, 87, 70,
				33);
		List<Integer> data1 = Arrays.asList(1, 1, 2, 3, 3, 4);
		List<Integer> data2 = Arrays.asList(1, 1, 2, 3, 3, 4, 4);
		List<Integer> data3 = Arrays.asList(1, 2, 3, 3, 4, 4, 5, 6, 6);

		
		System.out.println(countingSort(data));
		
		// 0, 2, 1, 2, 1, 0 - Rest All Zeros
		System.out.println(countingSort(data1));
		
		// 0, 2, 1, 2, 2, 0 - Rest All Zeros
		System.out.println(countingSort(data2));
		
		//0, 1, 1, 2, 2, 1, 2, 0 - Rest All Zeros
		System.out.println(countingSort(data3));
	}

	public static List<Integer> countingSort(List<Integer> arr) {

		List<Integer> result = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			result.add(i, 0);
		}

		for (int i = 0; i < arr.size(); i++) {

			if (result.get(arr.get(i)) == 0) {
				result.set(arr.get(i), 1);
			} else {
				result.set(arr.get(i), result.get(arr.get(i)) + 1);
			}
		}

		return result;
	}

}
