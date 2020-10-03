package com.practise.hacker;

import java.util.Arrays;

public class MinimumSwaps2 {
	
	public static void main(String[] args) {
		int[] unorderedArray =  {1,3,5,2,4,6,7};
		System.out.println("Minimum Swaps : " +minimumSwaps(unorderedArray));
	}
	
	
	private static int minimumSwaps(int[] arr) {
		
		int swapCount = 0;
		for(int i=0; i<arr.length-1; i++) {
			int element = arr[i];
			int count = i+1;
			 while(arr[i] > arr[count]) {
				 count++;
				 
				 if(count > arr.length-1)break;
			 }
			 
			 if(!(count == i+1)) {
				 arr[i] = arr[count-1];
				 arr[count-1] = element;
				 
				 swapCount+=1;
				 i--;
			 }
			
			
		}
		
		Arrays.stream(arr).forEach(a -> System.out.print(a +","));
		
	//	1,4, 3,2,5,6,7
		
	//	1,2,3,4,5,6,7
		
		
		return swapCount;
	}
	

}
