package com.practise.ds.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function <b>'countConstruct(target,, wordBank)'</b> that accepts a
 * target string and an array of strings. <br/>
 * The function should return the number of ways that the <b>'target'</b> can be
 * constructed by concatenating elements of the <b>'wordBank'</b> array. <br/>
 * You may <b>reuse elements of 'wordBank' as many times </b> as needed. <br/>
 * <br/>
 * <b>Technique Used :</b> Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class CountConstruct {
	
	public static void main(String[] args) {
		String[] wordBank = new String[] { "ab", "abc", "cd", "def", "abcd" };
		System.out.println(countConstruct("abcdef", wordBank, new HashMap<>()));                // 1
		
		wordBank = new String[] { "purp", "p", "ur", "le", "purpl" };
		System.out.println(countConstruct("purple", wordBank, new HashMap<>()));                // 2
		
		wordBank = new String[] { "a", "p", "ent", "enter", "ot", "o", "t"};
		System.out.println(countConstruct("enterapotentpot", wordBank, new HashMap<>()));       // 4
		
		wordBank = new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar"};
		System.out.println(countConstruct("skateboard", wordBank, new HashMap<>()));            // 0
		
		wordBank = new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				wordBank, new HashMap<>()));  											        // 0
		
	}
	
	/**
	 * Using recursion with memoization
	 * 
	 * @param target   : Target string which combination need to be searched
	 * @param wordBank : array of input strings
	 * @param memo     : memo object
	 * @return Integer : no of combinations found otherwise 0
	 */
	private static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {

		// Memo : check if data is there in memo
		if (memo.containsKey(target)) {
			return memo.get(target);
		}

		// Base case : When target string is empty, construction is possible
		if (target.equals("")) {
			return 1;
		}

		int totalCount = 0;
		for (String word : wordBank) {

			// Check if target starts with the word
			if (target.startsWith(word)) {

				// if target starts with word then do sub-string and remove the word to make a
				// new target
				// Add the count to total count
				totalCount += countConstruct(target.substring(word.length()), wordBank, memo);
			}
		}

		// Put count of a target string in memo
		memo.put(target, totalCount);
		return totalCount;
	}

}
