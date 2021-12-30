package com.practise.algo.sort;

import com.practise.util.Util;

/**
 * The selection sort improves on the bubble sort by reducing the number of
 * swaps necessary from O(n^2) to O(n). Unfortunately, the number of comparisons
 * remains O(n^2). However, the selection sort can still offer a significant
 * improvement for large records that must be physically moved around in memory,
 * causing the swap time to be much more important than the comparison time.
 * (Typically, this isn’t the case in Java, where references are moved around,
 * not entire objects.)
 *       <pre> Complexities of Selection sort is as below :   
 *        <b> Best : Ω(n^2) </b>
 *        <b> Average : Θ(n^2) </b>
 *        <b> Worst : O(n^2) </b>
 *       </pre>
 *       
 * @author Sanjeev
 *
 * @param <E>
 */
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
				if (Util.compare(array[minPosition], array[i]) > 0) {
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

}
