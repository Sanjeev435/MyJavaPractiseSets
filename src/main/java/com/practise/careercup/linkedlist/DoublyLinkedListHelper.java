package com.practise.careercup.linkedlist;


public class DoublyLinkedListHelper {

	protected Node head;
	protected Node tail;
	
	protected void add(int nodeData) {
		Node node = new Node(nodeData);

		if (head == null) {
			head = node;
		} else {
			tail.next = node;
			node.prev = tail;
		}
		tail = node;
	}
	
	protected String toNodeString(Node node) {
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
	
	protected static class Node {
		protected int data;
		protected Node next;
		protected Node prev;

		public Node(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}
}
