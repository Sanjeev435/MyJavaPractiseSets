package com.practise.algo.search.binary;

import com.practise.algo.search.binary.BinarySearchSampleObject.BinarySearchSampleDTO;

public class BinarySearchRecursive {

public static void main(String[] args) {
	
	int aInput = 767;
	System.out.println("Size of Int Array :"
			+ BinarySearchSampleObject.getIntArray().length + "\n"
			+ "Int array contents :");
	for (int element : BinarySearchSampleObject.getIntArray())
		System.out.print(element + " ");
	System.out.println("\nSearch for : "+aInput);
	searchNumberInArray(BinarySearchSampleObject.getIntArray(), aInput);

	String aString = "Ana";
	System.out.println("\nSize of String Array :"
			+ BinarySearchSampleObject.getStringArray().length + "\n"
			+ "String array contents :");
	for (String element : BinarySearchSampleObject.getStringArray())
		System.out.print(element + " ");
	System.out.println("\nSearch for : "+aString);
	searchNameInArray(BinarySearchSampleObject.getStringArray(), aString);

	String firstName = "Rohit";
	System.out.println("\nSize of String Array :"
			+ BinarySearchSampleObject.getClassObjArray().length + "\n"
			+ "BinarySearchSampleDTO Array contents :");
	for (BinarySearchSampleDTO element : BinarySearchSampleObject
			.getClassObjArray())
		System.out.println(element.getId() + " ,"
				+ element.getEmpFirstName() + " ," + element.emplastName);
	System.out.println("\nSearch for first name : "+firstName);
	searchNameInClassArray(BinarySearchSampleObject.getClassObjArray(),
			firstName);
}
 
private static void searchNameInClassArray(
		BinarySearchSampleDTO[] classObjArray, String firstName) {
	// TODO Auto-generated method stub
	
}

private static void searchNameInArray(String[] stringArray, String aString) {
	// TODO Auto-generated method stub
	
}

static void searchNumberInArray(int[] is, int aInput){
	
}
}
