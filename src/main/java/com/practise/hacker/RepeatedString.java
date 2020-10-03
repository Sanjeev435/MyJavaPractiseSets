package com.practise.hacker;

/**
 * 
 * @author Sanjeev
 * 
 * </br></br>
 Lilah has a string,<b>s</b> , of lowercase English letters that she repeated infinitely many times.</br>
Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.</br>
For example, if the string <b>s='abcac'</b> and <b>n=10</b>, the substring we consider is <b>abcacabcac</b>, the first </br>
<b>10</b> characters of her infinite string. </br>
There are <b>4</b> occurrences of a in the substring.</br>
</br></br>
<b>Function Description : </b><br>
-----------------------------------------------</br>
Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences </br>
of a in the prefix of length <b>n</b> in the infinitely repeating string.</br>

repeatedString has the following parameter(s):</br>
s: a string to repeat</br>
n: the number of characters to consider</br>
</br>
</br>
<b>Input Format : </b></br>
--------------------------------------</br>
The first line contains a single string, <b>s</b>.
The second line contains an integer, <b>n</b>.
</br></br>
<b>Constraints : </b></br>
--------------------------------------------------</br>
<b>1<=|s|<=100</b></br>
<b>1<=n<=10^12</b></br>
For <b>25%</b> of the test cases, <b>n<=10^6</b>.</br>
</br>
<b>Output Format : </b></br>
-------------------------------------------------</br>
Print a single integer denoting the number of letter a's in the first <b>n</b> letters of the infinite string created by repeating <b>s</b></br>
infinitely many times.
</br></br>
<b>Sample Input : </b></br>
-------------------------------------------------</br>
aba</br>
10</br>
</br>
<b>Sample Output </b></br>
------------------------</br>
7</br>
</br>
<b>Explanation : </b></br>
------------------------</br>
The first <b>n=10</b> letters of the infinite string are abaabaabaa. Because there are <b>7</b> a's, we print <b>7</b> on a new line.
</br></br>
<b>Sample Input : </b></br>
-------------------------------------------------</br>
a</br>
1000000000000</br>
</br>
<b>Sample Output </b></br>
------------------------</br>
1000000000000</br>
</br>
<b>Explanation : </b></br>
------------------------</br>
Because all of the first <b>1000000000000</b> letters of the infinite string are a, we print <b>1000000000000</b> on a new line.
 
 *
 */


public class RepeatedString {
	public static void main(String[] args) {
		System.out.println(repeatedString(
				"ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",
				685118368975L));
	}

	private static long repeatedString(String s, long n) {
		long actualACount = 0;
		long countAInStr = getACount(s);

		if (countAInStr == s.length()) {
			return n;
		} else {
			long quotient = n / s.length();
			long remainder = n % s.length();

			actualACount += quotient * countAInStr;
			if (remainder != 0) {
				actualACount += getACount(s.substring(0, (int) remainder));
			}
		}
		return actualACount;
	}

	private static int getACount(String s) {
		int countAInStr = 0;
		for (String str : s.split("")) {
			if (str.equals("a")) {
				countAInStr += 1;
			}
		}
		return countAInStr;
	}

}
