package com.practise.geeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class kthSmallestElement {

	public static void main(String[] args) {
		String[] data = { "2", "6", "7 10 4 3 20 15", "3", "5", "7 10 4 20 15", "4" };
		getKthSmallestNumUsingMethod(data);
		System.out.println("--------------------------------");

		/* getKthSmallestNumUsingDS(data); */
		System.out.println("--------- maximumContainers ------------------");

		// 4 , 3 , 5
		maximumContainers(Arrays.asList("5", "7 2 3", "12 4 4", "6 2 2", "8 4 2", "7 2 3"));
		// maximumContainers(Arrays.asList("1", "6 2 2"));
		System.out.println("--------- List ------------------");
		List<Integer> test = Arrays.asList(40, 8, 6, 22, 9, 7, 50);
		updateList(test);
		System.out.println(test);
	}

	private static void getKthSmallestNumUsingMethod(String[] data) {
		for (int i = 2; i < data.length; i += 3) {
			String[] arrData = data[i].split(" ");
			List<Integer> intData = Arrays.stream(arrData).map(Integer::valueOf).collect(Collectors.toList());
			Collections.sort(intData);
			System.out.println(intData.get(Integer.valueOf(data[i + 1]) - 1));
		}
	}

	/*
	 * private static List<String> getKthSmallestNumUsingDS(String[] data) { for
	 * (int i = 2; i < data.length; i += 3) { String[] arrData =
	 * data[i].split("n]9 +. "); List<Integer> intData =
	 * Arrays.stream(arrData).map(Integer::valueOf).collect(Collectors.toList());
	 * Collections.sort(intData);
	 * System.out.println(intData.get(Integer.valueOf(data[i + 1]) - 1));
	 * 
	 * } return Arrays.asList("Buenos Aires", "Córdoba", "La Plata"); }
	 */

	public static void maximumContainers(List<String> scenarios) {
		// Write your code here
		for (int i = 0; i < Integer.valueOf(scenarios.get(0)); i++) {
			String[] arrData = scenarios.get(i + 1).split(" ");
			List<Integer> intData = Arrays.stream(arrData).map(Integer::valueOf).collect(Collectors.toList());
			Integer startingValue = intData.get(0) / intData.get(1);
			Integer tempValue = startingValue;
			Double d = 0.0d;
			while (tempValue >= intData.get(2)) {
				d = Double.valueOf(tempValue) / Double.valueOf(intData.get(2));
				tempValue = tempValue / intData.get(2);
				startingValue += tempValue;
			}

			if (Math.round(d) > tempValue) {
				startingValue += 1;
			}

			System.out.println(startingValue);
		}

	}

	public static void updateList(List<Integer> list) {
		boolean foundError = true;
		while (foundError) {
			List<Integer> tempList = new ArrayList<>(list);
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i - 1) > list.get(i) && list.get(i + 1) > list.get(i)) {
					tempList.remove(i);
					list = new ArrayList<>(tempList);
					foundError = true;
					break;
				}
				foundError = false;
			}
		}

	}

}