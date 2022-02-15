package com.practise.careercup.arraysandstrings;

import java.util.Arrays;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Check Permutation : </b> Given two strings, write a method to decide if one is a permutation of the
other
 *
 */
public class StringPermutation {

	public static void main(String[] args) {
		System.out.println(checkPermutationUsingSort("grgce", "grgce"));                  //true
		System.out.println(checkPermutationUsingSort("dfdgkpo", "gfkpdod"));              //true
		System.out.println(checkPermutationUsingSort("ikrgvsfby", "vkfyirbgs"));          //true
		System.out.println(checkPermutationUsingSort("ikrgvsffnnby", "vkfyikbtrbg"));     //false
		System.out.println(checkPermutationUsingSort("ikrgvsffnnbyf", "vkfyikbtrbg"));    //false
		System.out.println(checkPermutationUsingSort("ikrgpcbfvsfby", "vkfqyknyirbg"));   //false
		
		System.out.println("-----------------------------------------------------------------------");
		
		System.out.println(checkPermutationUsingCount("grgce", "grgce"));                 //true
		System.out.println(checkPermutationUsingCount("dfdgkpo", "gfkpdod"));             //true
		System.out.println(checkPermutationUsingCount("ikrgvsfby", "vkfyirbgs"));          //true
		System.out.println(checkPermutationUsingCount("ikrgvsffnnby", "vkfyikbtrbg"));    //false
		System.out.println(checkPermutationUsingCount("ikrgvsffnnbyf", "vkfyikbtrbg"));    //false
		System.out.println(checkPermutationUsingCount("ikrgpcbfvsfby", "vkfqyknyirbg"));  //false
	}

	private static boolean checkPermutationUsingSort(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		Arrays.sort(s1);
		Arrays.sort(s2);

		return new String(s1).equals(new String(s2));
	}
	
	private static boolean checkPermutationUsingCount(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		int[] charArray = new int[128];
				
		for(char c : str1.toCharArray()) {
			charArray[c] += 1;
		}
		
		for(char c : str2.toCharArray()) {
			if(charArray[c] == 0) {
				return false;
			}
			charArray[c]--;
		}

		return true;
	}
}
