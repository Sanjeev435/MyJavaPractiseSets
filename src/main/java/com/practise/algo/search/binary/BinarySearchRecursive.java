package com.practise.algo.search.binary;

import java.util.Arrays;

import com.practise.dto.BinarySearchSampleDTO;

public class BinarySearchRecursive {

	public static void main(String[] args) {

		int aInput = 767;
		System.out.println(
				"Size of Int Array :" + BinarySearchSampleObject.getIntArray().length + "\n" + "Int array contents :");
		for (int element : BinarySearchSampleObject.getIntArray())
			System.out.print(element + " ");
		System.out.println("\nSearch for : " + aInput);
		searchNumberInArray(BinarySearchSampleObject.getIntArray(), aInput);

		String aString = "Ana";
		System.out.println("\nSize of String Array :" + BinarySearchSampleObject.getStringArray().length + "\n"
				+ "String array contents :");
		for (String element : BinarySearchSampleObject.getStringArray())
			System.out.print(element + " ");
		System.out.println("\nSearch for : " + aString);
		searchNameInArray(BinarySearchSampleObject.getStringArray(), aString);

		String firstName = "Rohit";
		System.out.println("\nSize of String Array :" + BinarySearchSampleObject.getClassObjArray().length + "\n"
				+ "BinarySearchSampleDTO Array contents :");
		for (BinarySearchSampleDTO element : BinarySearchSampleObject.getClassObjArray())
			System.out.println(element.getId() + " ," + element.getEmpFirstName() + " ," + element.getEmplastName());
		System.out.println("\nSearch for first name : " + firstName);
		searchNameInClassArray(BinarySearchSampleObject.getClassObjArray(), firstName);
	}

	private static void searchNameInClassArray(BinarySearchSampleDTO[] classObjArray, String firstName) {
		System.out.println(Arrays.toString(classObjArray) + " : " + firstName);

	}

	private static void searchNameInArray(String[] stringArray, String aString) {
		System.out.println(Arrays.toString(stringArray) + " : " + aString);
	}

	static void searchNumberInArray(int[] is, int aInput) {
		System.out.println(Arrays.toString(is) + " : " + aInput);
	}
}
