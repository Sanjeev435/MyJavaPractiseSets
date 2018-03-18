
package com.practise.hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * You have been given a String S consisting of uppercase and lowercase English
 * alphabets. You need to change the case of each alphabet in this String. That
 * is, all the uppercase letters should be converted to lowercase and all the
 * lowercase letters should be converted to uppercase. You need to then print
 * the resultant String to output.
 * 
 * 
 * Input Format The first and only line of input contains the String S
 * 
 * Output Format Print the resultant String on a single line.
 * 
 * Constraints 1≤|S|≤100 where |S| denotes the length of string S.
 * 
 * SAMPLE INPUT : abcdE
 * 
 * SAMPLE OUTPUT : ABCDe
 */

public class ToggleString {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * BufferedReader + InputStreamReader (Classic) 
		 * Scanner (JDK 1.5)
		 * System.Console (JDK 1.6)
		 * 
		 * Note : System.console() is usable only outside IDE. So can't be tested in IDE.
		 *
		 */

		// BufferedReader
		/*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Something : ");
		String line = br.readLine();*/

		// Scanner
		
		  Scanner s = new Scanner(System.in); 
		  System.out.println("Enter Something : "); 
		 String line = s.nextLine();
		 
		// System.Console
		/*System.out.println("Enter Something : ");
		String line = System.console().readLine();*/

		char[] aCharArray = line.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (char aChar : aCharArray) {
			if (Character.isUpperCase(aChar)) {
				sb.append(String.valueOf(aChar).toLowerCase());
			} else {
				sb.append(String.valueOf(aChar).toUpperCase());
			}
		}
		System.out.println(sb.toString());
	}

}


