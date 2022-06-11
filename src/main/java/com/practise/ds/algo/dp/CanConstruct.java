package com.practise.ds.algo.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a function <b>'canConstruct(target, wordBank)'</b> that accepts a
 * target string and an array of strings. <br/>
 * The function should return a boolean indicating whether or not the 'target'
 * can be constructed by concatenating elements of the 'wordBank' array. <br/>
 * You can reuse elements of 'wordBank' as many times as needed. <br/>
 * <br/>
 * <b>Technique Used :</b> Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class CanConstruct {
	
	public static void main(String[] args) {
		String[] wordBank = new String[] { "ab", "abc", "cd", "def", "abcd" };
		System.out.println(canConstruct("abcdef", wordBank, new HashMap<>()));          // true
		
		wordBank = new String[] { "a", "p", "ent", "enter", "ot", "o", "t"};
		System.out.println(canConstruct("enterapotentpot", wordBank, new HashMap<>())); // true

		wordBank = new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar"};
		System.out.println(canConstruct("skateboard", wordBank, new HashMap<>()));       // false
		
		wordBank = new String[] { "e", "ee", "eee", "eeee", "eeeee", "eeeeee"};
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
				wordBank, new HashMap<>()));                                             // false
	}

	/**
	 * Using recursion with memoization
	 * 
	 * @param target    : Target string which combination need to be searched
	 * @param wordBank  : array of input strings
	 * @param memo      : memo object
	 * @return boolean  : true if construction is possible otherwise false
	 */
	private static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {

		// Memo : check if data is there in memo
		if (memo.containsKey(target)) {
			return memo.get(target);
		}
		// Base case : When target string is empty, construction is possible
		if (target.equals("")) {
			return true;
		}

		for (String word : wordBank) {
			// Check if target starts with the word
			if (target.startsWith(word)) {

				// if target starts with word then do sub-string and remove the word to make a
				// new target
				boolean canConstruct = canConstruct(target.substring(word.length()), wordBank, memo);
				memo.put(target, canConstruct); // put data in memo
				if (canConstruct) {
					return true;
				}
			}
		}

		// Put negative target strings
		memo.put(target, false);
		return false;
	}
	

}
