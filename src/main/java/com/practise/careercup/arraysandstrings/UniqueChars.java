package com.practise.careercup.arraysandstrings;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Is Unique: </b> Implement an algorithm to determine if a string
 *         has all unique characters without using additional data structures
 *
 */
public class UniqueChars {
	
	public static void main(String[] args) {
		System.out.println(containUniqueChars("Sanjeev")); // false
		System.out.println(containUniqueChars("hgzbkielqo6wj")); //true
	}
	
	private static boolean containUniqueChars(String str) {
		boolean[] chars = new boolean[128];
		
		for(char s : str.toCharArray()) {
			if(chars[s]) {
				return false;
			}else {
				chars[s] = true;
			}
		}
		
		return true;
	}

}
