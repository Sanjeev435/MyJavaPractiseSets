package com.practise.hacker;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.practise.util.Util;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : String Manipulation</b> </br>
 *         <b>Problem Difficulty : Basic</b></br>
 * @see <a href=
 *      "https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings">
 *      Sherlock and the Valid String </a>
 *
 */
public class SherlockValidStringChecker {

	public static void main(String[] args) throws Exception {
		
		  System.out.println(isValid("aac")); // YES 
		  System.out.println(isValid("ab")); // YES 
		  System.out.println(isValid("abc")); // YES
		  System.out.println(isValid("abcc")); // YES
		  System.out.println(isValid("abccc")); // NO
		  System.out.println(isValid("aabbcd")); // NO
		  System.out.println(isValid("aabbccddeefghi")); // NO
		  System.out.println(isValid("abcdefghhgfedecba")); // YES
		  
		  System.out.println(isValid(
				  Util.getFileContentFromResource("big" + File.separator
						  + "files" + File.separator +"bigTestFile.txt")));

	}

	/*
	 * Complete the 'isValid' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING s as
	 * parameter.
	 */
	public static String isValid(String s) {
		Map<String, Long> tempMap = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		boolean diffFound = false;
		Long occurence = 0L;
		for (Map.Entry<String, Long> data : tempMap.entrySet()) {
			if (!data.getKey().equals("")) {
				if (occurence == 0) {
					occurence = data.getValue();
				} else {
					if (data.getValue() - occurence != 0) {
						if ((Math.abs(data.getValue() - occurence) == 1 || data.getValue() == 1 || occurence == 1) && !diffFound) {
							diffFound = true;
						} else {
							return "NO";
						}
					}
				}
			}

		}

		return "YES";
	}

}
