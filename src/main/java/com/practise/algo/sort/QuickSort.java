package com.practise.algo.sort;

import com.practise.util.Util;

/**
 * <b>Quicksort algorithm</b> is based on the divide and conquer approach where
 * an array is divided into sub-arrays by selecting a <b>pivot element</b>. </br>
 * While dividing the array, the pivot element should be positioned in such a
 * way that elements less than pivot are kept on the left side and elements
 * greater than pivot are on the right side. </br>
 * The same process is continued for both left and right sub-arrays. Finally,
 * sorted elements are combined to form a sorted array </br>
 * 
 * <pre>

 *  Time Complexities of Quick sort is as below :   
 *        <b> Best : Ω(n log(n)) </b>
 *        <b> Average : Θ(n log(n)) </b>
 *        <b> Worst : O(n^2) </b>
 * 
 * </pre>
 * 
 * 
 * 
 * @author Sanjeev Kumar
 *
 * @param <E>
 */
public class QuickSort<E extends Object> {

	private E[] array;

	public QuickSort(E[] array) {
		this.array = array;
	}

	public void sort() {
		if (array == null || array.length < 2) {
			return;
		}

		initateSorting(0, array.length - 1);
	}

	/**
	 * Initiate Sorting
	 * 
	 * @param low
	 * @param high
	 */
	private void initateSorting(int low, int high) {
		if (low < high) {

			// find pivot element such that
			// elements smaller than pivot are on the left
			// elements greater than pivot are on the right
			int pi = partition(low, high);

			// recursive call on the left of pivot
			initateSorting(low, pi - 1);

			// recursive call on the right of pivot
			initateSorting(pi + 1, high);
		}
	}

	/**
	 * Method to find the partition position </br>
	 * Method that consider last element as pivot, place the pivot at its exact
	 * position, and place smaller elements to left of pivot and greater elements to
	 * right of pivot
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	private int partition(int low, int high) {

		// choose the rightmost element as pivot
		E pivot = array[high];

		// pointer for greater element
		int i = (low - 1);

		// traverse through all elements
		// compare each element with pivot
		for (int j = low; j < high; j++) {
			if (Util.compare(array[j], pivot) <= 0) {

				// if element smaller than pivot is found
				// swap it with the greater element pointed by i
				i++;

				// swapping element at i with element at j
				E temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}

		}

		// swap the pivot element with the greater element specified by i
		E temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;

		// return the position from where partition is done
		return (i + 1);
	}

}
