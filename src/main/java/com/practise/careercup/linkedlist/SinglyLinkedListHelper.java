package com.practise.careercup.linkedlist;


public class SinglyLinkedListHelper {
	public Node head;
	public Node tail;
	public int size;
	
	/**
	 * Get contents of linked list in a string format.
	 */
	@Override
	public String toString() {
		if (head == null) {
			return "";
		}
		
		StringBuilder sb = new StringBuilder("[");
		
		Node node = head;
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
	
	public String toNodeString(Node node) {
		if (node == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder("[");

		while (node != null) {
			sb.append(node.data);
			if (node.next != null) {
				sb.append(", ");
			} else {
				sb.append("]");
			}
			node = node.next;
		}

		return sb.toString();
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			tail = node;
		}
		size+=1;
	}
	
	public int size() {
		return size;
	}

	public static class Node{
		public Node next;
		public int data;
		
		Node(int data){
			this.data = data;
			this.next = null;	
		}
	}
}
