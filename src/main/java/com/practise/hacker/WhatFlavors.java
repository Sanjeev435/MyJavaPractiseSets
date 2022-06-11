package com.practise.hacker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Hashmaps</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem">Hash
 *      Tables: Ice Cream Parlor</a>
 *
 */
public class WhatFlavors {

	public static void main(String[] args) {
		whatFlavors(Arrays.asList(1, 4, 5, 3, 2), 4); // 1, 4
		whatFlavors(Arrays.asList(1, 2, 3, 5, 6), 5); // 2, 3

	}

	private static void whatFlavors(List<Integer> cost, int money) {
		Map<Integer, Integer> table = new HashMap<>();

		int count = 1;
		for (Integer c : cost) {

			if (table.get(c) != null) {
				System.out.println("" + table.get(c) + " " + count);
				break;
			} else {
				table.put((money - c), count);
			}
			count++;
		}
	}

}
