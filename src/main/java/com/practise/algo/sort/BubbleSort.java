package com.practise.algo.sort;

public class BubbleSort<E extends Object> {

	private E[] array;

	public BubbleSort(E[] array) {
		this.array = array;
	}

	/**
	 * Sort the array is ascending order
	 */
	public void sort() {
		int length = array.length;

		for (int i = length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				if (compare(array[j], array[j + 1]) > 0) {
					swap(j, j + 1);
				}
			}
		}
	}

	/**
	 * Swap the elements within array
	 * 
	 * @param nthPosition
	 * @param n1Position
	 */
	private void swap(int nthPosition, int n1Position) {
		E temp = array[nthPosition];

		array[nthPosition] = array[n1Position];
		array[n1Position] = temp;
	}
	
	/**
	 * Compare two elements
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	private int compare(E obj1, E obj2) {
		if(obj1 instanceof String) {
			return ((String) obj1).compareTo((String)obj2);
		}else if(obj1 instanceof Integer) {
			return ((Integer) obj1).compareTo((Integer)obj2);
		}
		else {
			return 0;
		}
	}
}
