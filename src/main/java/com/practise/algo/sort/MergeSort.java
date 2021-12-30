package com.practise.algo.sort;

import java.lang.reflect.Array;

import com.practise.util.Util;

/**
 * The top-down merge sort approach is the methodology which uses recursion
 * mechanism. It starts at the Top and proceeds downwards, with each recursive
 * turn asking the same question such as <b>"What is required to be done to sort
 * the array?"</b> and having the answer as, <b>"split the array into two, make
 * a recursive call, and merge the results."</b> , until one gets to the bottom
 * of the array-tree. </br>
 * </br>
 * The elements of the array are sorted in <b>ascending order</b>. If we want to
 * sort the elements in <b>descending order</b>, then inside the first while
 * loop of the merge() method, we can change the code as: </br>
 * <b>The less than sign should be changed to greater than (Line No. 80) </br>
 * <code>
 * if (Util.compare(array[i], array[j]) <= 0)
 * </code></b>
 * 
 * <pre>
 *  Complexities of Merge sort is as below :   
 *        <b> Best : Ω(n log(n)) </b>
 *        <b> Average : Θ(n log(n)) </b>
 *        <b> Worst : O(n log(n)) </b>
 * 
 * </pre>
 * 
 * @author Sanjeev Kumar
 *
 * @param <E>
 */
public class MergeSort<E extends Object> {

	private E[] array;

	public MergeSort(E[] array) { 
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
	 * @param start : index to start from
	 * @param end   : index till sorting operates
	 */
	private void initateSorting(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			initateSorting(start, mid);
			initateSorting(mid + 1, end);
			merge(start, mid, end);
		}
	}

	/**
	 * 
	 * @param start
	 * @param mid
	 * @param end
	 */
	private void merge(int start, int mid, int end) {
		// create a temp array
		@SuppressWarnings("unchecked")
		E temp[] = (E[]) Array.newInstance(array.getClass().getComponentType(), end - start + 1);

		// crawlers for both intervals and for temp
		int i = start, j = mid + 1, k = 0;

		// traverse both arrays and in each iteration add smaller of both elements in temp
		while (i <= mid && j <= end) {
			if (Util.compare(array[i], array[j]) <= 0) {
				temp[k] = array[i];
				k += 1;
				i += 1;
			} else {
				temp[k] = array[j];
				k += 1;
				j += 1;
			}
		}

		// add elements left in the first interval
		while (i <= mid) {
			temp[k] = array[i];
			k += 1;
			i += 1;
		}

		// add elements left in the second interval
		while (j <= end) {
			temp[k] = array[j];
			k += 1;
			j += 1;
		}

		// copy temp to original interval
		for (i = start; i <= end; i += 1) {
			array[i] = temp[i - start];
		}
	}

}
