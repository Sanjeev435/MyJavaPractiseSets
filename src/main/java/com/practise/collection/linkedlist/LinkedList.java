package com.practise.collection.linkedlist;

import java.util.NoSuchElementException;

import com.practise.util.Util;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Custom Linked List</b><br/>
 *         <br/>
 * 
 *         <b><u>Implemented Functions : </u></b><br/>
 * 
 *         <b>void add(E a) -></b> Appends the specified element to the end of
 *         this list.<br/>
 *         <b>boolean offer(E data) -></b> Adds the specified element as the
 *         tail (last element) of this list.<br/>
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
 *         list.<br/>
 * 
 * @param <E>
 */
public class LinkedList<E> {

	private int size;
	private Node<E> head;
	private Node<E> tail;

	/**
	 * Appends the specified element to the end of this list.
	 */
	public void add(E a) {
		Node<E> node = new Node<>(a);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size += 1;
	}

	/**
	 * Adds the specified element as the tail (last element) of this list.
	 * 
	 * @param e
	 */
	public boolean offer(E data) {
		if (tail != null) {
			Node<E> node = new Node<>(data);

			tail.next = node;
			tail = node;

			size += 1;

			return true;
		}

		return false;
	}
	
	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 * @return
	 */
	public E get(int index) {
		if (head == null || index > size()) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}

		Node<E> node = head;
		int count = 0;
		while(node != null) {
			if(count == index) {
				return node.data;
			}
			node = node.next;
			
			count++;
		}
		return null;
	}
	
	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 * 
	 * @param element
	 */
	public E element() {
		if (head != null) {
			return head.data;
		} else {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}
	}

	/**
	 * Retrieves, but does not remove, the head (first element) of this list.
	 */
	public E peek() {
		if (head == null) {
			throw new IllegalStateException("Linked List is not intialized !!");
		} else {
			return head.data;
		}
	}

	/**
	 * Retrieves and removes the head (first element) of this list.
	 */
	public E poll() {
		if (head == null) {
			throw new IllegalStateException("Linked List is not intialized !!");
		} else {
			E data = head.data;

			if (head.next == null) {
				this.head = null;
				this.tail = null;
			} else {
				head = head.next;
			}

			size -= 1;

			return data;
		}
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
		if (head == null || index > size()) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}

		Node<E> node = head;
		Node<E> preNode = null;
		int count = 0;
		while (node != null) {
			if (count == index) {
				E data = node.data;
				preNode.next = node.next;
				
				size -= 1;
				
				return data;
			}
			preNode = node;
			node = node.next;
			count++;
		}

		return null;
	}

	/**
	 * Returns the index of the first occurrence of the specified element in this
	 * list, or -1 if this list does not contain the element
	 * 
	 * @param data
	 */
	public int indexOf(E data) {
		Node<E> node = head;
		int count = 0;

		if (head == null) {
			throw new NoSuchElementException("Linked List is not intialized !!");
		}

		while (node != null) {
			if (Util.compare(node.data, data) == 0) {
				return count;
			}
			node = node.next;
			count++;
		}

		return -1;
	}

	/**
	 * Returns the number of elements in this list.
	 */
	public int size() {
		return this.size;
	}

	private static class Node<E> {
		private E data;
		private Node<E> next;

		Node(E data) {
			this.next = null;
			this.data = data;
		}
	}
}
