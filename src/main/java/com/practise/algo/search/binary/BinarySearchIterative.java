package com.practise.algo.search.binary;

import com.practise.util.Util;

/**
 * This class consists of iterative form of binary search algorithm.
 * 
 * Below class has example of binary search algorithm implementation of
 * primitive type data, String type and for class type object.
 * 
 * @author Sanjeev
 *
 */
public class BinarySearchIterative<E extends Object> {

	private E[] array;

	public BinarySearchIterative(E[] array) {
		this.array = array;
	}

	/**
	 * Binary search implementation for primitive type data
	 */
	public boolean search(E searchElement) {
		int startPoint = 0;
		int endPoint = array.length - 1;
		boolean found = false;
		
		while (startPoint <= endPoint) {
			int midPoint = (startPoint + endPoint) / 2;
			
			if (Util.compare(searchElement, array[midPoint]) == 0) {
				found = true;
				break;
			} else if (Util.compare(searchElement, array[midPoint]) > 0) {
				startPoint = midPoint + 1;
			} else if (Util.compare(searchElement, array[midPoint]) < 0) {
				endPoint = midPoint - 1;
			}
		}
		
		return found;
	}
}
