package com.practise.careercup.arraysandstrings;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>String Rotation : </b> Assume you have a method isSubstring which
 *         checks if one word is a substring of another. Given two strings, s1
 *         and s2, write code to check if s2 is a rotation of sl using only one
 *         call to isSubstring<br/>
 * 
 *         <pre>
 *         <b>Example : </b>
 *         <b>"waterbottle"</b> is a rotation of <b>"erbottlewat"</b>
 *         </pre>
 *
 */
public class StringRotation {
	
	public static void main(String[] args) {
		System.out.println(isRotation("pillow", "wopill"));            //false
		System.out.println(isRotation("beautiful", "ifulbeau"));       //false
		System.out.println(isRotation("earthworm", "rmearthwo"));      //true
		System.out.println(isRotation("waterbottle", "erbottlewat"));  //true
	}
	
	private static boolean isRotation(String str1, String str2) {
		if(!str1.isEmpty() && !str2.isEmpty()) {
			if(str1.length() == str2.length()) {
				String str1str1 = str1+str1;
				return isSubstring(str1str1, str2);
			}
		}
		return false;
	}

	private static boolean isSubstring(String str1str1, String str2) {
		return str1str1.contains(str2);
	}

}
