package com.practise.careercup.arraysandstrings;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b> Palindrome Permutation:</b> Given a string, write a function to
 *         check if it is a permutation of a palindrome. A palindrome is a word
 *         or phrase that is the same forwards and backwards. A permutation is a
 *         rearrangement of letters. The palindrome does not need to be limited
 *         to just dictionary words.
 * 
 *         <pre>
 *         <b>Example Input:</b> 
 *         <b>Tact Coa Output:</b> True (permutations: "taco cat", "atco eta", etc.)
 *         </pre>
 *
 */
public class PalindromePermutation {

	public static void main(String[] args) {

		System.out.println(isPermutationOfPalindrome("aa"));         // true
		System.out.println(isPermutationOfPalindrome("madam"));      // true
		System.out.println(isPermutationOfPalindrome("race car"));   // true
		System.out.println(isPermutationOfPalindrome("Tact Coa"));   // true
		System.out.println(isPermutationOfPalindrome("redivider"));  // true

		System.out.println(isPermutationOfPalindrome("laptop"));     // false
	}

	private static boolean isPermutationOfPalindrome(String value) {

		Map<String, Long> occurences = Arrays.stream(value.split(""))
				.collect(Collectors.groupingBy(String::toUpperCase, Collectors.counting()));

		boolean isOddDataFound = false;
		for (Map.Entry<String, Long> data : occurences.entrySet()) {
			if (!data.getKey().trim().equals("") && data.getValue() % 2 == 1) {
				if (isOddDataFound) {
					return false;
				} else {
					isOddDataFound = true;
				}
			}
		}
		return true;
	}

}
