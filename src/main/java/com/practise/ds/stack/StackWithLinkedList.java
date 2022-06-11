package com.practise.ds.stack;

import java.util.NoSuchElementException;

import com.practise.careercup.linkedlist.SinglyLinkedListHelper;

/*push ( i tern): Add an item to the end of the list.
remove (): Remove the first item in the list.
peek ( ) : Return the top of the queue.
pop ( ) :  Removes the object at the top of this stack and returns that object
is Empty(): Return true if and only if the queue is empty.*/
/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Stack implementation with Linked List</b><br/>
 *         <br/>
 * 
 *         <b><u>Implemented Functions : </u></b><br/>
 * 
 *         <b>void add(E a) -></b> Appends the specified element to the top of stack<br/>
 *         <b>boolean offer(E data) -></b> Adds the specified element as the
 *         tail (last element) of this list.<br/>
 *         <b>void insertNodeAtPosition(int position, E data) -></b> Adds the 
 *         specified element at the given position index.<br/>
 *         <br/>
 * 
 *         <b>E element() -></b> Retrieves, but does not remove, the head (first
 *         element) of this list.<br/>
 *         <b>E peek() -></b> Retrieves, but does not remove, the head (first
 *         element) of this list.<br/>
 *         <br/>
 * 
 * 
 *         <b>E poll() -></b> Retrieves and removes the head (first element) of
 *         this list.<br/>
 *         <b>E remove() -></b> Retrieves and removes the head (first element)
 *         of this list.<br/>
 *         <b>E remove(int index) -></b> Removes the element at the specified
 *         position in this list.<br/>
 *         <br/>
 * 
 *         <b>int indexOf(E data) -></b> Returns the index of the first
 *         occurrence of the specified element in this list, or -1 if this list
 *         does not contain the element<br/>
 *         <br/>
 * 
 *         <b>int size() -></b> Returns the number of elements in this
 *         list.<br/><br/>
 *         
 *         <b>String toString() -></b> Get contents of linked list in a string 
 *         format.<br/>
 * 
 * @param <E>
 */
public class StackWithLinkedList extends SinglyLinkedListHelper{
	
	
	public void push(int data) {
		add(data);
	}
	
	public int remove(int index) {
		if (index >= size || index < 0) {
			throw new NoSuchElementException("Index is not available | Index : " + index);
		}
		
		int data = -1;
		if(head.next == null && index == 0) {
			data = head.data;
			head = tail = null;
		}else {
			Node node = head;
			Node pre = null;
			while (index >= 0) {
				if (index == 0) {
					pre.next = node.next;
					if(node.next == null) {
						tail = pre;
					}
					size-=1;
					return node.data;
				}

				index--;
				pre = node;
				node = node.next;
			}
		}

		size-=1;
		return data;
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object as the
	 * value of this function.
	 * 
	 * @return int : The object at the top of this stack
	 * 
	 * 
	 */
	public int pop() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is Empty !!");
		}
		
		int data = tail.data;
		if(size == 1) {
			tail = null;
			head = null;
		}else {
			Node preTail = null;
			Node node = head;
			
			int count = size();
			while(count > 0) {
				if(count == 1) {
					preTail.next = null;
					tail = preTail;
				}
				preTail = node;;
				node = node.next;
				
				count--;
			}
		}
		
		size-=1;
		if(size == 1) {
			head = tail;
		}
		return data;
	}
	
	
	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is Empty !!");
		}
		return tail.data;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

}
