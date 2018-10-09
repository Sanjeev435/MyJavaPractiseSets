package com.practise.stack;

/**
 * 
 * @author Sanjeev
 *
 * @param <T>
 */
public interface Stack<T> {

	/**
	 * 
	 * @param item
	 * @throws Exception
	 */
	void push(T item) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	T pop() throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	T peek() throws Exception;

	/**
	 * 
	 * @return
	 */
	boolean isEmpty();

	/**
	 * 
	 * @return
	 */
	boolean isFull();
}
