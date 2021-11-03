package com.practise.algo.sort;

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
 *  Complexities of Heap sort is as below :   
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

}
