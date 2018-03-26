package com.practise.array;

public class HighArray {
	private long[] a; 
	private int nElems;
	
	/** ----------------------------------------------------------- **/

	public HighArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	/** ----------------------------------------------------------- **/
	
	public boolean find(long searchKey) {
		int j;
		for (j = 0; j < nElems; j++)
			if (a[j] == searchKey)
				break;
		if (j == nElems)
			return false;
		else
			return true;
	}

	/** ----------------------------------------------------------- **/

	public void insert(long value){
		a[nElems] = value; 
		nElems++;
	}

	/** ----------------------------------------------------------- **/
	
	public boolean delete(long value) {
		int j;
		for (j = 0; j < nElems; j++) // look for it
			if (value == a[j])
				break;
		if (j == nElems) // can’t find it
			return false;
		else // found it
		{
			for (int k = j; k < nElems; k++) // move higher ones down
				a[k] = a[k + 1];
			nElems--; // decrement size
			return true;
		}
	}
	
	/** ----------------------------------------------------------- **/

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println(" ");
	}
	
	/** ----------------------------------------------------------- **/
	
	public void findMax() {
		if(a == null || a.length==0) {
			System.out.println("No elements in array "+ (-1));
		}
		
		long maxValue = a[0];
		
		for(long value : a) {
			if(value > maxValue) {
				maxValue = value;
			}
		}
		
		System.out.println("Maximum value in array is "+maxValue);
	}
}
