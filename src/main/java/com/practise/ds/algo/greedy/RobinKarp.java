package com.practise.ds.algo.greedy;

/**
 * 
 * @author Sanjeev Kumar
 * 
 * 
 *         <br/>
 *         <br/>
 *         <b>Rabin-Karp algorithm</b> is an algorithm used for
 *         searching/matching patterns in the text using a hash function. Unlike
 *         Naive string matching algorithm, it does not travel through every
 *         character in the initial phase rather it filters the characters that
 *         do not match and then performs the comparison.<br/>
 *         <br/>
 * 
 *         <b>Limitations of Rabin-Karp Algorithm :</b> <br/><b><i>Spurious Hit
 *         </i></b> : When the hash value of the pattern matches with the hash
 *         value of a window of the text but the window is not the actual
 *         pattern then it is called a spurious hit.<br/>
 *         Spurious hit increases the time complexity of the algorithm. In order
 *         to minimize spurious hit, we use modulus. It greatly reduces the
 *         spurious hit.<br/>
 *         <br/>
 * 
 *         <b>Rabin-Karp Algorithm Complexity :</b><br/>
 *         The average case and best case complexity of Rabin-Karp algorithm is
 *         <b>O(m + n)</b> and the worst case complexity is <b>O(mn)</b>.<br/>
 * 
 *         The worst-case complexity occurs when spurious hits occur a number
 *         for all the windows.<br/>
 *         <br/>
 * 
 *         <b>Rabin-Karp Algorithm Applications :</b><br/>
 *         For pattern matching For searching string in a bigger text<br/>
 *
 */
public class RobinKarp {
	// numOfAlphabetChars is the number of characters in the input alphabet
	public final static int numOfAlphabetChars = 256;

	/**
	 * 
	 * @param pattern  : pattern text
	 * @param txt      : text string
	 * @param primeNum : a prime number
	 */
	public static void search(String pattern, String txt, int primeNum) {
		int patternLength = pattern.length();
		int textLength = txt.length();
		int patternHashValue = 0;
		int textHashValue = 0;
		int h = 1;

		// The value of h would be "pow(d, m-1)%q"
		for (int i = 0; i < patternLength - 1; i++) {
			h = (numOfAlphabetChars * h) % primeNum;
		}

		// Calculate hash value for pattern and text
		for (int i = 0; i < patternLength; i++) {
			patternHashValue = (numOfAlphabetChars * patternHashValue + pattern.charAt(i)) % primeNum;
			textHashValue = (numOfAlphabetChars * textHashValue + txt.charAt(i)) % primeNum;
		}

		// Find the match
		// Slide the pattern over text one by on
		for (int i = 0; i <= textLength - patternLength; i++) {

			// Check the hash values of current window of text and pattern. If the hash
			// values match then only check for characters one by one
			if (patternHashValue == textHashValue) {

				/* Check for characters one by one */
				int j;
				for (j = 0; j < patternLength; j++) {
					if (txt.charAt(i + j) != pattern.charAt(j))
						break;
				}

				// if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
				if (j == patternLength)
					System.out.println("Pattern is found at position: " + (i + 1));
			}

			// Calculate hash value for next window of text: Remove leading digit, add
			// trailing digit
			if (i < textLength - patternLength) {
				textHashValue = (numOfAlphabetChars * (textHashValue - txt.charAt(i) * h)
						+ txt.charAt(i + patternLength)) % primeNum;

				// We might get negative value of t, converting it to positive
				if (textHashValue < 0)
					textHashValue = (textHashValue + primeNum);
			}
		}
	}

	public static void main(String[] args) {
		String txt = "ABCCDDAEFG";
		String pattern = "CDD";
		int q = 13;
		search(pattern, txt, q);
	}
}
