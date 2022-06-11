package com.practise.ds.queue;

import java.util.NoSuchElementException;

/*It uses the operations:
add ( i tern): Add an item to the end of the list.
peek ( ) : Return the top of the queue.
is Empty(): Return true if and only if the queue is empty.
int remove(int i) removed the specified element
poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
*/
public class QueueWithArray {

	int size;
	int capacity;

	Integer[] data = null;

	public QueueWithArray() {
		size = 0;
		capacity = 5;
		data = new Integer[capacity];
	}

	public void add(int value) {
		if (size == capacity - 2) {
			updateIndex();
		}
		data[size] = value;
		size++;
	}

	public boolean remove(int value) {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		boolean dataFound = false;
		for (int i = 0; i < size; i++) {
			if (data[i] == value) {
				dataFound = true;
			}

			if (dataFound) {
				if (i + 1 < size) {
					data[i] = data[i + 1];
				} else {
					data[i] = null;
				}
			}
		}

		if (dataFound) {
			size -= 1;
		}

		return dataFound;
	}

	public Integer poll() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}

		Integer value = data[0];
		for (int i = 0; i < size; i++) {
			if (i + 1 < size) {
				data[i] = data[i + 1];
			} else {
				data[i] = null;
			}
		}
		
		size-=1;
		return value;
	}

	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		return data[0];
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		if (size == 0) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("[");
		
		for(int i=0; i<size; i++) {
			sb.append(data[i]);
			if(i < size-1) {
				sb.append(", ");
			}else {
				sb.append("]");
			}
		}
		
		return sb.toString();
	}

	private void updateIndex() {
		this.capacity = this.size * 2;
		Integer[] tempArray = new Integer[this.capacity];
		for (int i = 0; i < this.size; i++) {
			tempArray[i] = this.data[i];
		}
		this.data = tempArray;
	}

}
