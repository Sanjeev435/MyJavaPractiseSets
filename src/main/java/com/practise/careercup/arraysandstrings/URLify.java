package com.practise.careercup.arraysandstrings;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>URLify : </b> Write a method to replace all spaces in a string
 *         with '%20'. You may assume that the string has sufficient space at
 *         the end to hold the additional characters, and that you are given the
 *         "true" length of the string. (Note: If implementing in Java, please
 *         use a character array so that you can perform this operation in
 *         place.)<br/>
 * 
 *         <pre>
 *         <b>Example : </b>
 *         <b>Input:</b>"Mr John Smith ", 13
 *         <b>Output:</b>"Mr%20John%20Smith"
 *         </pre>
 *
 */
public class URLify {

	public static void main(String[] args) {
		System.out.println(performURLify("Mr John Smith    ", 13));
	}

	/**
	 * 
	 * @param str
	 * @param actualLength 
	 * @return
	 */
	private static String performURLify(String str, int actualLength) {
		
		char[] array = str.toCharArray();
		
		int index = actualLength-1;
		for(int i = array.length-1; i >= 0; i--) {
			if(str.charAt(index) == ' ') {
				array[i] = '0';
				array[i-1] = '2';
				array[i-2] = '%';
				
				i-=2;
			}else {
				array[i] = str.charAt(index);
			}
			index--;
		}

		return new String(array);
	}
}
