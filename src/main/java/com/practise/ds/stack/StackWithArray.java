package com.practise.ds.stack;

import java.util.NoSuchElementException;

/*push ( i tern): Add an item to the end of the list.
 * add ( i tern): Add an item to the end of the list.
int remove (int index): Remove the first item in the list.
int peek ( ) : Return the top of the queue but dont remove.
int pop ( ) :  Removes the object at the top of this stack and returns that object
is Empty(): Return true if and only if the queue is empty.*/
public class StackWithArray {
	int size;
	int capacity;
	int[] data = null;
	
	public StackWithArray(){
		size = 0;
		capacity = 5;
		this.data = new int[5];
	}
	
	public void push(int data) {
		if(size == capacity) {
			expandArray();
		}
		
		this.data[size] = data;
		
		size+=1;
	}
	
	public void add(int data) {
		push(data);
	}
	
	public int pop() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		
		int value = this.data[size-1];
		this.data[size-1] = 0;
		
		size-=1;
		
		return value;
	}
	
	public int remove(int index) {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		if (index >= size || index < 0) {
			throw new NoSuchElementException("Index is not available | Index : " + index);
		}

		int value = -1;
		for (int i = 0; i < size; i++) {
			if (i == index) {
				value = data[i];
				// Perform shifting
				for (int j = i; j < size; j++) {
					if (j + 1 < size) {
						data[j] = data[j + 1];
					}
				}
				break;
			}
		}
		size-=1;
		return value;
	}
	
	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		return this.data[size-1];
	}

	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
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

	private void expandArray() {
		int[] tempArray = new int[size*2];
		for(int i=0; i<size; i++) {
			tempArray[i] = data[i];
		}
		this.data = tempArray;
		this.capacity = tempArray.length;
	}

}
