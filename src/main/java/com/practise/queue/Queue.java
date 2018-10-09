package com.practise.queue;

/**
 * Queue Implementation
 * 
 *  * <table BORDER CELLPADDING=3 CELLSPACING=1>
 * <caption>Summary of Queue methods</caption>
 *  <tr>
 *    <td></td>
 *    <td ALIGN=CENTER><em>Throws exception</em></td>
 *    <td ALIGN=CENTER><em>Returns special value</em></td>
 *  </tr>
 *  <tr>
 *    <td><b>Insert</b></td>
 *    <td>{@link QueueWithArray#add add(e)}</td>
 *    <td>{@link QueueWithArray#offer offer(e)}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Remove</b></td>
 *    <td>{@link QueueWithArray#remove remove()}</td>
 *    <td>{@link QueueWithArray#poll poll()}</td>
 *  </tr>
 *  <tr>
 *    <td><b>Examine</b></td>
 *    <td>{@link QueueWithArray#element element()}</td>
 *    <td>{@link QueueWithArray#peek peek()}</td>
 *  </tr>
 * </table>
 * 
 * @author Sanjeev
 *
 */
public interface Queue<T> {

	 boolean add(T item) throws IllegalAccessException;
	 
	 boolean isFull();
	 
	 boolean offer(T item);
	 
	 T remove();
	 
	 T peek();
	 
	 int size();
	 
	 boolean isEmpty();
}
