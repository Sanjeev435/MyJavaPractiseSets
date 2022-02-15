package com.practise.careercup.arraysandstrings;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>String Compression : </b> Implement a method to perform basic
 *         string compression using the counts of repeated characters. For
 *         example, the string <b>aabcccccaaa</b> would become <b>a2blc5a3</b>.
 *         If the "compressed" string would not become smaller than the original
 *         string, your method should return the original string. You can assume
 *         the string has only uppercase and lowercase letters (a - z).<br/>
 * 
 *         <pre>
 *         <b>Example : </b>
 *         <b>aabcccccaaa -></b> a2b1c5a3
 *         </pre>
 *
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(getCompressedString("abcd"));          //abcd
		System.out.println(getCompressedString("aabbccaa"));      //aabbccaa
		System.out.println(getCompressedString("aabcccccaaa"));   //a2b1c5a3
		System.out.println(getCompressedString("abbcccccddde"));  //a1b2c5d3e1
	}

	private static String getCompressedString(String str) {
		StringBuffer sb = new StringBuffer();
		int count = 1;

		char lastChar = str.charAt(0);
		sb.append(lastChar);

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != lastChar) {
				sb.append(count);
				sb.append(str.charAt(i));
				lastChar = str.charAt(i);
				count = 0;
			}

			if (i == str.length() - 1) {
				sb.append(count + 1);
			}
			count++;
		}

		return sb.toString().length() < str.length() ?  sb.toString() : str;
	}

}
