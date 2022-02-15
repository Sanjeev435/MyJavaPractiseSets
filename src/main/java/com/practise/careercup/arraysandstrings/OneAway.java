package com.practise.careercup.arraysandstrings;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>One Away : </b> There are three types of edits that can be
 *         performed on strings: insert a character, remove a character, or
 *         replace a character. Given two strings, write a function to check if
 *         they are one edit (or zero edits) away.<br/>
 * 
 *         <pre>
 *         <b>Example : </b>
 *         <b>pale, ple -></b> true
 *         <b>pale, bale -></b> true
 *         <b>pales, pale -></b> true
 *         <b>pale, bake -></b> false
 *         <b>goalss, goal -></b> false
 *         </pre>
 *
 */
public class OneAway {

	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "ple"));      //true
		System.out.println(isOneAway("pale", "bale"));     //true
		System.out.println(isOneAway("pales", "pale"));    //true
		System.out.println(isOneAway("pale", "bake"));     //false
		System.out.println(isOneAway("palss", "passs"));   //true
		System.out.println(isOneAway("goalss", "goal"));   //false
		
		System.out.println("--------------------------------------");
		
		System.out.println(isOneAway("ple", "pale"));      //true
		System.out.println(isOneAway("bale", "pale"));     //true
		System.out.println(isOneAway("pale", "pales"));    //true
		System.out.println(isOneAway("bake", "pale"));     //false
		System.out.println(isOneAway("passs", "palss"));   //true
		System.out.println(isOneAway("goal", "goalss"));   //false
	}

	private static boolean isOneAway(String str1, String str2) {
		String bigStr = str1.length() - str2.length() >= 0 ? str1 : str2;
		String smallStr = str1.length() - str2.length() >= 0 ? str2 : str1;
		
		
		if(bigStr.length() - smallStr.length() > 1) {
			return false;
		}
		
		int[] str1Arr = new int[128];
		
		for(char c : bigStr.toCharArray()) {
			str1Arr[c]++;
		}
		
		int countDiffernce = bigStr.length() - smallStr.length();
		for (char c : smallStr.toCharArray()) {
			if (str1Arr[c] <= 0) {
				countDiffernce++;
			}
			str1Arr[c]--;

			if (countDiffernce > 1) {
				return false;
			}
		}
		

		return true;
	}

}
