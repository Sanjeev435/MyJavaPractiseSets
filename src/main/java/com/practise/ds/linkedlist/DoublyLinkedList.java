package com.practise.ds.linkedlist;

import java.util.NoSuchElementException;

import com.practise.util.Util;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Custom Doubly Linked List</b><br/>
 *         <br/>
 * 
 *         <b><u>Implemented Functions : </u></b><br/>
 * 
 *         <b>void add(E a) -></b> Appends the specified element to the end of
 *         this list.<br/>
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
public class DoublyLinkedList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	private int size;

	/**
	 * Appends the specified element to the end of this list.
	 */
	public void add(E data) {
		Node<E> node = new Node<>(data);
		
		if(this.head != null) {
			node.prev = this.tail;
			this.tail.next = node;
		}else {
			this.head = node;
		}
		
		this.tail = node;
		this.size += 1;
	}
	
	/**
	 * Adds the specified element as the tail (last element) of this list.
	 * 
	 * @param e
	 */
	public boolean offer(E data) {
		if(this.tail == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
		
		Node<E> temp  = new Node<>(data);
		temp.prev = this.tail;
		this.tail.next = temp;
		this.tail = temp;
		
		this.size += 1;
		
		return true;
	}
	
	/**
	 * Insert data at a given position
	 * 
	 * @param data
	 * @param positionIndex
	 */
	public void insertNodeAtPosition(int positionIndex, E data) {
		if (head == null || positionIndex > this.size || positionIndex < 0) {
			throw new NoSuchElementException("Invalid index argument !!");
		}

		Node<E> node = head;
		Node<E> tempNode = new Node<>(data);
		boolean isheadNeedUpdate = positionIndex == 0 ? true : false;
		boolean isTailNeedUpdate = positionIndex == this.size ? true : false;

		if (isTailNeedUpdate) {
			tail.next = tempNode;
			tempNode.prev = tail;
			tail = tempNode;
		} else {
			while (positionIndex >= 0) {
				if (positionIndex == 0) {

					tempNode.prev = node.prev;
					tempNode.next = node;

					if (node.prev != null) {
						node.prev.next = tempNode;
					}
					node.prev = tempNode;
					updateHead(isheadNeedUpdate, tempNode);
				}
				node = node.next;
				positionIndex -= 1;
			}
		}

		size += 1;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (this.head == null || index >= size() || index < 0) {
			throw new NoSuchElementException("Invalid index argument !!");
		}
		
		boolean isForward = index < size()/2;
		Node<E> node = isForward ? this.head : this.tail;
		
		if(isForward) {
			for(int i = index; i > 0; i--) {
				node = node.next;
			}
		}else {
			for(int i = (size() - index); i > 1; i--) {
				node = node.prev;
			}
		}
		
		return node.data;
	}
	
	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 * 
	 * @param element
	 */
	public E element() {
		if (this.head == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
		
		return this.head.data;
	}
	
	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 */
	public E peek() {
		if (this.head == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
		
		return this.head.data;
	}
	
	/**
	 * Retrieves and removes the head (first element) of this list.
	 */
	public E poll() {
		if (this.head == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
		
		Node<E> temp = this.head;
		
		if(this.size == 1) {
			this.head = null;
			this.tail = null;
		}else {
			this.head = this.head.next;
			this.head.prev = null;
		}
		this.size -= 1;
		
		return temp.data;
	}
	
	/**
	 * Retrieves and removes the head (first element) of this list.
	 */
	public E remove() {
		return poll();
	}
	
	/**
	 * Removes the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 */
	public E remove(int index) {
		if (head == null || index >= size() || index < 0) {
			throw new NoSuchElementException("Invalid index argument !!");
		}

		boolean isTailNeedUpdate = index == this.size - 1 ? true : false;
		Node<E> temp = this.head;
		E data = null;

		if (this.size == 1) {
			data = head.data;
			this.head = null;
			this.tail = null;
		} else {
			while (temp != null) {
				if (index == 0) {
					data = temp.data;

					if (temp.prev != null) {
						temp.prev.next = temp.next;
					}
					if (temp.next != null) {
						temp.next.prev = temp.prev;
					}

					updateTail(isTailNeedUpdate, temp.next);
					break;
				}
				temp = temp.next;
				index -= 1;
			}
		}
		
		size -= 1;

		return data;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element
	 * 
	 * @param data
	 */
	public int indexOf(E data) {
		if (head == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
		
		int count = 0;
		Node<E> node = this.head;
		
		while(node != null) {
			if(Util.compare(node.data, data) == 0) {
				return count;
			}
			
			count +=1;
			node = node.next;
		}
		
		return -1;
	}
	
	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Get contents of linked list in a string format.
	 */
	@Override
	public String toString() {
		if (head == null) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("[");
		
		Node<E> node = head;
		while(node != null) {
			sb.append(node.data);
			if(node.next != null) {
				sb.append(", ");
			}else {
				sb.append("]");
			}
			node = node.next;
		}
		
		return sb.toString();
	}
	
	private void updateHead(boolean isheadNeedUpdate, Node<E> node) {
		if(isheadNeedUpdate) {
			head = node;
		}
	}
	
	private void updateTail(boolean isTailNeedUpdate, Node<E> next) {
		if(isTailNeedUpdate) {
			tail = next;
		}
	}
	
	private static class Node<E> {
		private E data;
		private Node<E> next;
		private Node<E> prev;

		Node(E data) {
			this.prev = null;
			this.next = null;
			this.data = data;
			
		}
	}
}
