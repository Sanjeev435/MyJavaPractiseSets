package com.practise.hacker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FredoAndMaths {

	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * BufferedReader + InputStreamReader (Classic) 
		 * Scanner (JDK 1.5)
		 * System.Console (JDK 1.6)
		 * 
		 * Note : System.console() is usable only outside IDE. So can't be
		 * tested in IDE.
		 */

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter three number X, K, M : ");
		boolean validTestCaseRange = true;
		Integer numOfTestCase = 0;
		String[] lines = null;
		Integer count = 0;
		String line;
		
		while ((line = br.readLine()) != null && line.length() != 0) {
			try {
				if (count == 0) {
					numOfTestCase = Integer.parseInt(line.trim());
					if (numOfTestCase < 1 || numOfTestCase > Math.pow(10, 5)) {
						validTestCaseRange = false;
					}
					lines = new String[numOfTestCase];
				} else {
					lines[count - 1] = line;
				}
			} catch (Exception ex) {
				System.out.println("Error while parsing line.");
				throw ex;
			}
			if (numOfTestCase.compareTo(count) == 0) {
				break;
			}
			if (!validTestCaseRange) {
				break;
			}
			count++;
		}
		
		if (lines != null && lines.length > 0) {
			for (String inputLine : lines) {
				Integer x = null;
				Integer k = null;
				Integer m = null;

				String[] arrayOfNum = inputLine.split(" ");
				boolean sizeOfInputCorrect = (arrayOfNum.length == 3 ? true
						: false);

				if (sizeOfInputCorrect) {
					boolean parsingFails = false;
					try {
						x = Integer.parseInt(arrayOfNum[0]);
						k = Integer.parseInt(arrayOfNum[1]);
						m = Integer.parseInt(arrayOfNum[2]);
					} catch (Exception ex) {
						parsingFails = true;
						System.out.println("Please input digits only from 0-9");
					}

					if (!parsingFails) {
						boolean validationFails = false;
						if (m < 1 || m > Math.pow(10, 7)) {
							validationFails = true;
							System.out
									.println("Please input correct value of M. Range of M is 1<= M <=10^7.");
						} else if (k < 1 || k > Math.pow(10, 18)) {
							validationFails = true;
							System.out
									.println("Please input correct value of K. Range of K is 1<= K <=10^18.");
						} else if (x < m || x > Math.pow(10, 8)) {
							validationFails = true;
							System.out
									.println("Please input correct value of X. Range of x is M<X,  X<=10^88.");
						} else if (!isPrimeNumber(x)) {
							validationFails = true;
							System.out
									.println("Please input correct value of X.It should be a prime number.");
						}

						if (!validationFails) {
							Double powerValue = x.doubleValue();
							Integer result = null;
							for (int i = 1; i < k; i++) {
								powerValue = Math.pow(x, powerValue);
							}
							result = Math.floorMod(powerValue.intValue(), m);
							System.out.println(result);
						}
					}
				}
			}
		}

	}

	/**
	 * validate a number prime or not
	 * 
	 * @param number
	 * @return
	 */
	private static boolean isPrimeNumber(int number) {
		for (int i = 2; i <= number / 2; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
