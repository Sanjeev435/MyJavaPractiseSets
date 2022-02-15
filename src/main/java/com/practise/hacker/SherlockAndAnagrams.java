package com.practise.hacker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : Dictionaries and Hashmaps</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps">Sherlock
 *      And Anagrams Problem</a>
 *
 */
public class SherlockAndAnagrams {

	public static void main(String[] args) {

		System.out.println("abba : " + sherlockAndAnagrams("abba")); // 4
		System.out.println("abcd : " + sherlockAndAnagrams("abcd")); // 10
		System.out.println("ifailuhkqq : " + sherlockAndAnagrams("ifailuhkqq")); // 3
		System.out.println("cdcd : " + sherlockAndAnagrams("cdcd")); // 5
		System.out.println("kkkk : " + sherlockAndAnagrams("kkkk")); // 10
	}

	/*
	 * Complete the 'sherlockAndAnagrams' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */
	public static int sherlockAndAnagrams(String s) {
		int count = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {

			if (i == 0) {
				map.put(s.substring(0, i + 1), 1);
			} else {
				for (int j = 0; j <= i; j++) {
					String str = sortString(s.substring(j, i + 1));

					if (map.containsKey(str)) {
						count += map.get(str);
					}

					map.put(str, map.get(str) != null ? map.get(str) + 1 : 1);
				}
			}
		}
		return count;
	}

	private static String sortString(String str) {
		if (str.length() > 1) {
			String[] s = str.split("");
			Arrays.sort(s);

			str = Arrays.toString(s);
		}
		return str;
	}

}
