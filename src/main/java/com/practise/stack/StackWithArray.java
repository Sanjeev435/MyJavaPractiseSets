package com.practise.stack;

/**
 * 
 * @author Sanjeev
 *
 * @param <T>
 */
public class StackWithArray<T extends Object> implements Stack<T> {
	private T[] stackedData;
	private Integer stackedDataSize;
	private Integer pointer;

	@SuppressWarnings("unchecked")
	public StackWithArray(int arraySize) {
		this.stackedData = (T[]) new Object[arraySize];
		this.stackedDataSize = arraySize;
		this.pointer = -1;
	}

	public void push(T item) throws Exception {
		if (isFull()) {
			throw new IllegalAccessException("Stack is full !!");
		}
		++pointer;
		stackedData[pointer] = item;
	}

	public T pop() throws Exception {
		if (isEmpty()) {
			throw new IllegalAccessException("Stack is empty !!");
		}
		return stackedData[pointer--];
	}

	public T peek() throws Exception {
		if (isEmpty()) {
			throw new IllegalAccessException("Stack is empty !!");
		}
		return stackedData[pointer];
	}

	public boolean isEmpty() {
		return pointer == -1;
	}

	public boolean isFull() {
		return pointer == stackedDataSize - 1;
	}

}
