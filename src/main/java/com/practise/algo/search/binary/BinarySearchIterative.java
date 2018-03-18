package com.practise.algo.search.binary;

import com.practise.algo.search.binary.BinarySearchSampleObject.BinarySearchSampleDTO;

/**
 * This class consists of iterative form of binary search algorithm.
 * 
 * Below class has example of binary search algorithm implementation of
 * primitive type data, String type and for class type object.
 * 
 * @author Sanjeev
 *
 */
public class BinarySearchIterative {

	public static void main(String[] args) {
		int aInput = 767;
		System.out.println("Size of Int Array :"
				+ BinarySearchSampleObject.getIntArray().length + "\n"
				+ "Int array contents :");
		for (int element : BinarySearchSampleObject.getIntArray())
			System.out.print(element + " ");
		System.out.println("\nSearch for : " + aInput);
		searchNumberInArray(BinarySearchSampleObject.getIntArray(), aInput);

		String aString = "Ana";
		System.out.println("\nSize of String Array :"
				+ BinarySearchSampleObject.getStringArray().length + "\n"
				+ "String array contents :");
		for (String element : BinarySearchSampleObject.getStringArray())
			System.out.print(element + " ");
		System.out.println("\nSearch for : " + aString);
		searchNameInArray(BinarySearchSampleObject.getStringArray(), aString);

		String firstName = "Rohit";
		System.out.println("\nSize of String Array :"
				+ BinarySearchSampleObject.getClassObjArray().length + "\n"
				+ "BinarySearchSampleDTO Array contents :");
		for (BinarySearchSampleDTO element : BinarySearchSampleObject
				.getClassObjArray())
			System.out.println(element.getId() + " ,"
					+ element.getEmpFirstName() + " ," + element.emplastName);
		System.out.println("\nSearch for first name : " + firstName);
		searchNameInClassArray(BinarySearchSampleObject.getClassObjArray(),
				firstName);

	}

	/**
	 * Binary search implementation for primitive type data
	 * 
	 * @param aIntArray
	 * @param aInput
	 */
	private static void searchNumberInArray(int[] aIntArray, int aInput) {
		int startPoint = 0;
		int endPoint = (aIntArray.length - 1);
		boolean notFound = true;
		while (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) / 2;
			if (aInput == aIntArray[midPoint]) {
				notFound = false;
				System.out.println("Number " + aInput + " found at position "
						+ (midPoint + 1) + " in the array.");
				break;
			} else if (aInput > aIntArray[midPoint]) {
				startPoint = midPoint + 1;
			} else if (aInput < aIntArray[midPoint]) {
				endPoint = midPoint - 1;
			}
		}
		if (notFound)
			System.out.println("Number " + aInput + " not found in the array.");

	}

	/**
	 * Binary search implementation for String type data
	 * 
	 * @param aStrArray
	 * @param aString
	 */
	private static void searchNameInArray(String[] aStrArray, String aString) {

		int startPoint = 0;
		int endPoint = aStrArray.length - 1;
		boolean notFound = true;
		while (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) / 2;
			if (aString.equalsIgnoreCase(aStrArray[midPoint])) {
				notFound = false;
				System.out.println("'" + aString + "' found at position "
						+ (midPoint + 1) + " in the array.");
				break;
			} else if (aString.compareTo(aStrArray[midPoint]) < 0) {
				endPoint = midPoint - 1;
			} else if (aString.compareTo(aStrArray[midPoint]) > 0) {
				startPoint = midPoint + 1;
			}
		}
		if (notFound)
			System.out.println("'" + aString + "' not found in the array.");
	}

	/**
	 * Binary search implementation for class type data
	 * 
	 * @param anArray
	 * @param firstName
	 */
	private static void searchNameInClassArray(BinarySearchSampleDTO[] anArray,
			String firstName) {
		int startPoint = 0;
		int endPoint = anArray.length - 1;
		boolean notFound = true;
		while (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) / 2;

			if (firstName.equalsIgnoreCase(anArray[midPoint].getEmpFirstName())) {
				System.out.println("'" + firstName + "' found with ID as '"
						+ anArray[midPoint].getId() + "', lastname as '"
						+ anArray[midPoint].emplastName + "' and at position "
						+ (midPoint + 1)
						+ " in the BinarySearchSampleDTO array.");
				notFound = false;
				break;
			} else if (firstName.compareTo(anArray[midPoint].getEmpFirstName()) > 0) {
				startPoint = midPoint + 1;
			} else if (firstName.compareTo(anArray[midPoint].getEmpFirstName()) < 0) {
				endPoint = midPoint - 1;
			}
		}

		if (notFound)
			System.out.println("Element with first name as '" + firstName
					+ "' not found in the BinarySearchSampleDTO array.");
	}

}
