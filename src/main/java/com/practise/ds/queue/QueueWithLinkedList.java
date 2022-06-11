package com.practise.ds.queue;

import java.util.NoSuchElementException;

import com.practise.careercup.linkedlist.SinglyLinkedListHelper;

/*It uses the operations:
add ( i tern): Add an item to the end of the list.
peek ( ) : Return the top of the queue.
is Empty(): Return true if and only if the queue is empty.
int remove(int i) removed the specified element
poll() Retrieves and removes the head of this queue, or returns null if this queue is empty.
*/
public class QueueWithLinkedList extends SinglyLinkedListHelper{
	
	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		
		int data = head.data;
		if(head.next == null) {
			head = null;
			tail = null;
		}else {
			head = head.next;
			if(head.next == null) {
				tail = head;
			}
		}
		
		size-=1;
		
		return data;
	}
	
	public boolean remove(int value) {
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		
		Node node = head;
		boolean dataFound = false;
		if(head.next == null) {
			if(head.data == value) {
				dataFound = true;
				head = null;
				tail = null;
			}
		}else {
			Node pre = null;
			while(node != null) {
				if(node.data == value) {
					dataFound = true;
					if(pre != null) {
						pre.next = node.next;
					}else {
						head = node.next;
						if(head.next == null) {
							tail = head;
						}
					}
					if(node.next == null) {
						tail = pre;
					}
				}
				pre = node;
				node =  node.next;
			}
		}
		
		if(dataFound) {
			size-=1;
		}
		
		return dataFound;
	}
	
	public int peek(){
		if (size == 0) {
			throw new NoSuchElementException("Stack is not initialized !!");
		}
		return head.data;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
}
