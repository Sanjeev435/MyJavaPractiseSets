package com.practise.algo.sort;

import java.util.Arrays;

import com.practise.util.Util;

/**
 * It is the slowest of the O(n log(n)) sorting algorithms but unlike merge and
 * quick sort it does not require massive recursion or multiple arrays to work.
 * This sorting technique is independent of distribution of data 
 * <pre>
 * 
 * If the parent node is stored at index I, the left child can be calculated 
 * by 2 * I + 1 and the right child by 2 * I + 2 (assuming the indexing starts at 0).
 * 
 * 
 *  Time Complexities of Heap sort is as below :   
 *        <b> Best : Ω(n log(n)) </b>
 *        <b> Average : Θ(n log(n)) </b>
 *        <b> Worst : O(n log(n)) </b>
 * </pre>
 * 
 * 
 * 
 * @author Sanjeev Kumar
 *
 * @param <E>
 */
public class HeapSort<E extends Object> {
	
	private E[] array;

	public HeapSort(E[] array) {
		this.array = array;
	}
	
	
	public void sort() {
		if(array == null || array.length < 2) {
			return;
		}
		
		int maxAllowedIndex = array.length;
		
		/*
		 * Build max-heap
		 * 
		 * To build a max-heap from any tree, we can thus start heapifying each sub-tree
		 * from the bottom up and end up with a max-heap after the function is applied
		 * to all the elements including the root element.
		 * 
		 * In the case of a complete tree, the first index of a non-leaf node is given
		 * by n/2 - 1. All other nodes after that are leaf-nodes and thus don't need to
		 * be heapified.
		 * 
		 * So, we can build a maximum heap as below.
		 */
		// Build max heap
		// Moving from the first element that isn't a leaf towards the root
		for (int i = maxAllowedIndex / 2 - 1; i >= 0; i--) {
			heapify(maxAllowedIndex, i);
		}
		System.out.println("Max Heap Builded");
		// Heap sort
		for (int i = maxAllowedIndex - 1; i >= 0; i--) {
			E temp = array[0];
			array[0] = array[i];
			array[i] = temp;
			
			System.out.println(Arrays.toString(array));

			// Heapify root element
			heapify(i, 0);
		}
	}
	
	
	/**
	 * <pre>
	 * 1. Build a max heap array using the input array. 
	 * 2. Since the max heap stores the largest element of the array at the top (that is, the beginning of the array), 
	 *    we need to swap it with the last element within the array, followed by reducing the size of the array (heap) by 1. 
	 *    After that, we heapify the root. 
	 * 3. We repeat step 2 as long as the size of our heap is bigger than 1
	 * </pre>
	 * @param maxAllowedIndex
	 * @param index
	 */
	private void heapify(int maxAllowedIndex, int index) {
		int leftChildIndex = 2 * index + 1;
		int rightChildIndex = 2 * index + 2;
		
		int largestIndex = index;
		
		if(leftChildIndex < maxAllowedIndex && Util.compare(array[leftChildIndex] , array[largestIndex]) > 0) {
			largestIndex = leftChildIndex;
		}
		if(rightChildIndex < maxAllowedIndex && Util.compare(array[rightChildIndex] ,array[largestIndex]) > 0) {
			largestIndex = rightChildIndex;
		}
		
		if(largestIndex != index) {
			E tmp = array[index];
			array[index] = array[largestIndex];
			array[largestIndex] = tmp;
			
			System.out.println(Arrays.toString(array));
			
			heapify(maxAllowedIndex, largestIndex);
		}
		
	}

}
