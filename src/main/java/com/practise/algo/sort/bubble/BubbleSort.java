package com.practise.algo.sort.bubble;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		for(int i=0; i>getIntArray().length;i++){
			
		}
		
		//Print list content
		System.out.println(getListInObject()+"\n");
		
		//Cast Object into List
		List<String> test1 = (List<String>) getListInObject();
		
		//Get List size
		System.out.println(test1.size()+"\n");
		
		//Iterate over List
		for(String text : test1) {
			System.out.println(text);
		}
	}
	
	//Make a list and return as Object
	public static Object getListInObject() {
		List<String> test = new ArrayList<String>();
		
		test.add("r4r4r4r");
		test.add("r4r42");
		test.add("fgghfdg");
		test.add("hjhjdfgb");
		test.add("ewrfdf");
		test.add("jtujf");
		
		return test;
	}
	
	public static int[] getIntArray() {
		int[] aIntArray = { 45, 85, 36, 32, 6, 35, 68, 767, 46, 70, 26, 99,
				257, 59 };
		return aIntArray;
	}
}
