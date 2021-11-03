package com.practise.algo.sort;

/**
 * In most cases the insertion sort is the best of the elementary sorts
 * described in this chapter. It still executes in O(n^2) time, but it’s about
 * twice as fast as the bubble sort and somewhat faster than the selection sort
 * in normal situations. It’s also not too complex, although it’s slightly more
 * involved than the bubble and selection sorts. It’s often used as the final
 * stage of more sophisticated sorts, such as quicksort.
 * 
 *       <pre> Complexities of Insertion sort is as below :   
 *        <b> Best : Ω(n) </b>
 *        <b> Average : Θ(n^2) </b>
 *        <b> Worst : O(n^2) </b>
 *       </pre>
 * 
 * @author Sanjeev
 *
 * @param <E>
 */
public class InsertionSort<E extends Object> {

	private E[] array;

	public InsertionSort(E[] array) {
		this.array = array;
	}
	
	/**
	 * Sort the Array
	 */
	public void sort() {
		int length = array.length;
		int out, in;

		for (out = 1; out < length; out++) {
			E temp = array[out];
			in = out;
			
			while(in > 0 && compare(array[in - 1], temp) > 0) {
				array[in] = array[in - 1];
				--in;
			}

			array[in] = temp;
		}
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
