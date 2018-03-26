package com.practise.algo.sort;

public class SelectionSort<E extends Object> {

	private E[] array;

	public SelectionSort(E[] array) {
		this.array = array;
	}

	/**
	 * Sort the Array
	 */
	public void sort() {
		int length = array.length;
		int minPosition = 0;
		boolean isSortNeeded = false;

		for (int j = 0; j < length; j++) {
			minPosition = j;
			isSortNeeded = false;
			
			for (int i = j+1; i < length; i++) {
				if (compare(array[minPosition], array[i]) > 0) {
					minPosition = i;
					isSortNeeded = true;
				}
			}
			if (isSortNeeded) {
				swap(j, minPosition);
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
		if (obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		} else if (obj1 instanceof Integer) {
			return ((Integer) obj1).compareTo((Integer) obj2);
		} else {
			return 0;
		}
	}

}
