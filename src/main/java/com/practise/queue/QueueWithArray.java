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
public class QueueWithArray<T extends Object> implements Queue<T>{
	
	T[] queue ;
	Integer frontPoint, endPoint, size;
	Integer maxSize;
	
	@SuppressWarnings("unchecked")
	public QueueWithArray(int queueSize) {
		queue = (T[]) new Object[queueSize];
		endPoint = -1;
		frontPoint = 0;
		maxSize = queueSize;
		size = 0;
	}
	
	/**
	 * Will always return true. Will throw exception is adding is unsuccessful
	 */
	public boolean add(T item) throws IllegalAccessException {
		if (item == null) {
			throw new NullPointerException();
		}
		
		if (isFull()) {
			throw new IllegalAccessException("Queue is full !!");
		} else {
			queue[++endPoint] = item;
			size++;
			return true;
		}
	}
	
	/**
	 * Will return true is success in adding else false.
	 * 
	 * @param item
	 */
	public boolean offer(T item) {
		if (item == null)
			throw new NullPointerException();

		if (isFull()) {
			return false;
		} else {
			queue[++endPoint] = item;
			size++;
			return false;
		}
	}
	
	public T remove() {
		T removedElement;

		if (isEmpty()) {
			throw new IllegalAccessError("Queue is Empty !!");
		} else {
			removedElement = queue[frontPoint++];
			if(frontPoint == maxSize) {
				frontPoint = 0;
			}
			size--;
		}
		return removedElement;
	}
	
	public T peek() {
		return queue[frontPoint];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return endPoint.equals(maxSize-1);
	}
	
	public boolean isEmpty() {
		return endPoint.equals(-1);
	}
	

}
