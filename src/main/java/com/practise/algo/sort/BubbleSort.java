package com.practise.algo.sort;

import com.practise.util.Util;

/**
 * 
 * @author Sanjeev Kumar
 *
 * 
 *         Under best-case conditions (the list is already sorted), the bubble
 *         sort can approach a constant O(n) level of complexity. General-case
 *         is an abysmal O(n^2). While the insertion, selection, and shell sorts
 *         also have complexities, they are significantly more efficient than
 *         bubble sort.
 * 
 *   <pre>Complexities of Bubble sort is as below :   
 *        <b> Best : Ω(n) </b>
 *        <b> Average : Θ(n^2) </b>
 *        <b> Worst : O(n^2) </b>
 *   </pre>
 * 
 * @author Sanjeev Kumar
 *
 * @param <E>
 */
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
				if (Util.compare(array[j], array[j + 1]) > 0) {
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
}
