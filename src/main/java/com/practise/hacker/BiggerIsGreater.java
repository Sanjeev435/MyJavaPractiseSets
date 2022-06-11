package com.practise.hacker;

import java.util.Arrays;

/**
 * @author Sanjeev Kumar
 * 
 *         </br>
 *         </br>
 *         <b>Problem Type : String</b> </br>
 *         <b>Problem Difficulty : Medium</b></br>
 * @see <a href= "https://www.hackerrank.com/challenges/bigger-is-greater">
 *      Bigger is greater </a>
 *
 */
public class BiggerIsGreater {

	public static void main(String[] args) {

		System.out.println(biggerIsGreater("ab"));         // ba
		System.out.println(biggerIsGreater("bb"));         // no answer
		System.out.println(biggerIsGreater("hefg"));       // hegf
		System.out.println(biggerIsGreater("fkwic"));      // hcdk
		System.out.println(biggerIsGreater("dhck"));       // dhkc
		System.out.println(biggerIsGreater("dkhc"));       // hcdk

		System.out.println(biggerIsGreater("lmno"));       // lmon
		System.out.println(biggerIsGreater("dcba"));       // no answer
		System.out.println(biggerIsGreater("dcbb"));       // no answer
		System.out.println(biggerIsGreater("abdc"));       // acbd
		System.out.println(biggerIsGreater("abcd"));       // abdc
		System.out.println(biggerIsGreater("fedcbabcd"));  // fedcbabdc
	}

	private static String biggerIsGreater(String w) {
		if (w.length() == 1) {
			return "no answer";
		}

		char[] wArr = w.toCharArray();

		boolean swapped = false;
		int pointer = wArr.length - 1;
		for (int i = wArr.length - 2; i >= 0; i--) {
			if (wArr[pointer] > (wArr[i])) {
				char temp = wArr[pointer];
				wArr[pointer] = wArr[i];
				wArr[i] = temp;

				pointer = i;
				swapped = true;

				break;
			} else if ((wArr[pointer] < (wArr[i])) && wArr[pointer] < wArr[0]) {
				pointer = i;
			}
		}

		sortLetters(wArr, pointer);

		return swapped ? new String(wArr) : "no answer";
	}

	private static void sortLetters(char[] wArr, int pointer) {
		char[] subArr = Arrays.copyOfRange(wArr, pointer + 1, wArr.length);
		Arrays.sort(subArr);
		for (int i = pointer + 1; i < wArr.length; i++) {
			wArr[i] = subArr[i - (pointer + 1)];
		}
	}
}
