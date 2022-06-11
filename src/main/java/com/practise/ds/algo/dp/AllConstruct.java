package com.practise.ds.algo.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function <b>'allConstruct(target,wordBank)'</b> that accepts a target
 * string and an array of strings. <br/><br/>
 * The function <b>should return a 2D array containing all of the ways</b> that
 * the <b>'target'</b> can be constructed by concatenating elements of the
 * <b>'wordBank'</b> array. Each element of the 2D array should <b>represent one
 * combination</b> that constructs the <b>'target'</b>. <br/><br/>
 * You may <b>reuse elements of 'wordBank' as many times</b> as needed.
 * <br/><br/>
 * <b>Technique Used :</b>  Recursion with memoization
 * 
 * @author Sanjeev Kumar
 *
 */
public class AllConstruct {

	/*
	 * public static void main1(String[] args) { // [["ab", "cd", "ef"], // ["ab",
	 * "c", "def"], // ["abc", "def"], // ["abcd", "ef"]] String[] wordBank = new
	 * String[] { "ab", "abc", "cd", "def", "abcd", "ef", "c" };
	 * System.out.println(allConstruct("abcdef", wordBank, new HashMap<>()));
	 * 
	 * // [[ab, c], [abc]] wordBank = new String[] { "ab", "c", "abc"};
	 * System.out.println(allConstruct("abc", wordBank, new HashMap<>()));
	 * 
	 * //[[purp, le], [p, ur, p, le]] wordBank = new String[] { "purp", "p", "ur",
	 * "le", "purpl" }; System.out.println(allConstruct("purple", wordBank, new
	 * HashMap<>()));
	 * 
	 * //[[enter, a, p, ot,ent, p, o, t] //[enter, a , p, o, t, ent, p, o, t],
	 * //[enter, a, p, o, t, ent, p, ot], //[enter, a, p, ot, ent, p, ot]] wordBank
	 * = new String[] { "a", "p", "ent", "enter", "ot", "o", "t"};
	 * System.out.println(allConstruct("enterapotentpot", wordBank, new
	 * HashMap<>()));
	 * 
	 * // null wordBank = new String[] { "bo", "rd", "ate", "t", "ska", "sk",
	 * "boar"}; System.out.println(allConstruct("skateboard", wordBank, new
	 * HashMap<>()));
	 * 
	 * // null wordBank = new String[] { "e", "ee", "eee", "eeee", "eeeee",
	 * "eeeeee"};
	 * System.out.println(allConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
	 * wordBank, new HashMap<>())); }
	 */

	public static void main(String[] args) {
		// [[ab, c], [abc]]
		String[] wordBank = new String[] { "ab", "c", "abc"};
		System.out.println(allConstruct("abc", wordBank));
		
	}

	private static List<List<String>> allConstruct(String target,
			String[] wordBank/* , Map<String, List<List<String>>> memo */) {

		/*
		 * if(memo.containsKey(target)) { return memo.get(target); }
		 */
		if (target.equals("")) {
			return new ArrayList<>();
		}
		
		List<List<String>> combinations = null;
		List<String> data = null;
		for(String word : wordBank) {
			if(target.startsWith(word)) {
				
				System.out.println("---------------------------------");
				System.out.println("word : " + word);
				List<List<String>> tempCombinations = allConstruct(target.substring(word.length()), wordBank);
				
				System.out.println("tempCombinations : " + tempCombinations);
				System.out.println("combinations : " + combinations);
				
				
				if(tempCombinations != null) {
					if(tempCombinations.size() == 0) {
						data = new ArrayList<>();
						data.add(word);
					}else {
						tempCombinations.get(tempCombinations.size()-1).add(word);
					}
					
						combinations = tempCombinations;
						
					
					
					
				}
				System.out.println("data : " + data);
				System.out.println("combinations : " + combinations);
				System.out.println("---------------------------------");
			}
		}
		
		System.out.println("data : " + data);
		combinations.add(data);
		//data.clear();
		System.out.println("combinationsssss : " + combinations);
		//memo.put(target, combinations);
		return combinations;
	}

}
