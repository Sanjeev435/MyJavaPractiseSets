package com.practise.algo.sort;

/**
 * In most cases the insertion sort is the best of the elementary sorts
 * described in this chapter. It still executes in O(N2) time, but it’s about
 * twice as fast as the bubble sort and somewhat faster than the selection sort
 * in normal situations. It’s also not too complex, although it’s slightly more
 * involved than the bubble and selection sorts. It’s often used as the final
 * stage of more sophisticated sorts, such as quicksort.
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
//		int minPosition = 0;
//		boolean isSortNeeded = false;

		int in, out;
		for(out=1; out<length; out++) // out is dividing line
		{
		E temp = array[out]; // remove marked item
		in = out; // start shifts at out
		while(in>0 && compare(array[in-1], temp) >=0) // until one is smaller,
		{
			array[in] = array[in-1]; // shift item right,
		--in; // go left one position
		}
		array[in] = temp; // insert marked item
		} // end for
		} // end insertionSort()

	/**
	 * Swap the elements within array
	 * 
	 * @param nthPosition
	 * @param n1Position
	 */
//	private void swap(int nthPosition, int n1Position) {
//		E temp = array[nthPosition];
//
//		array[nthPosition] = array[n1Position];
//		array[n1Position] = temp;
//	}

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
