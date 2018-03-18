package com.practise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayCommonMethods {

	public static void main(String[] args) {
		printArray(initializeArray());
		printArray(initializeArray1());
		printArray(deleteElement(initializeArray1(),"Hari"));
	}
	private static String[] initializeArray(){
		String[] strArray = {"Ram","Shayam","Mohan","Ram","Zakir"};
		
		return strArray;
	}
	
	private static String[] initializeArray1(){
		String[] strArray = new String[12];
		strArray[0]= "Ram";
		strArray[1]= "Shayam";
		strArray[2]= "Mohan";
		strArray[3]= "Ram";
		strArray[4]= "Zakir";
		strArray[5]= "Ramu";
		strArray[6]= "Rohit";
		strArray[7]= "Hari";
		strArray[8]= "Pankaj";
		strArray[9]= "Kabir";
		strArray[10]= "Anand";
		
		
		return strArray;
	}
	
	private static void printArray(Object[] strArray){
		System.out.println("---------------------------------------------------------------");
		System.out.println("Array size is : "+strArray.length);
		for(Object str : strArray){
			System.out.println("Element in array are : "+str);
		}
		System.out.println("---------------------------------------------------------------");
	}
	
	private static Object[] deleteElement(String[] strArray, String anElementToBeDel){
		System.out.println("Array size is : "+strArray.length);
				List<String> anList = new ArrayList<String>(Arrays.asList(strArray));
				
						anList.remove(anElementToBeDel);
						anList.removeAll(Collections.singleton(null));
						return anList.toArray();	
		}
}
