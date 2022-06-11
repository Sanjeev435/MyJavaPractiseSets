package com.practise.careercup.linkedlist;


public class SortedInsert extends DoublyLinkedListHelper{
	
	public static void main(String[] args) {

		SortedInsert list = new SortedInsert();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(10);
						
		System.out.println(list.toNodeString(list.sortedInsert(list.head, 11))); // 1, 3, 4, 10, 11
		System.out.println(list.toNodeString(list.sortedInsert(list.head, 0))); // 0, 1, 3, 4, 10, 11
		System.out.println(list.toNodeString(list.sortedInsert(list.head, 5))); // 1, 3, 4, 5, 10, 11

	}
	
	/*
	 * Complete the 'sortedInsert' function below.
	 *
	 * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST. 
	 * The function accepts following parameters: 1. INTEGER_DOUBLY_LINKED_LIST headNode 
	 * 											  2. INTEGER data
	 */
	public Node sortedInsert(Node headNode, int data) {
		Node tempHead = headNode;

		if (headNode == null) {
			return headNode;
		} else if (tempHead.data >= data) {
			// If node is inserted at head
			Node newNode = new Node(data);

			newNode.prev = tempHead.prev;
			tempHead.prev = newNode;
			newNode.next = tempHead;
			return tempHead;
		} else {
			Node newNode = new Node(data);

			// Additional buffer need in case of data being inserted at tail
			Node temp = tempHead;

			while (tempHead != null && tempHead.data <= data) {
				temp = tempHead;
				tempHead = tempHead.next;
			}

			// In case node is inserted at end
			if (tempHead == null) {
				temp.next = newNode;
				newNode.prev = temp;
			} else {
				// for all other places
				if (tempHead.prev != null) {
					tempHead.prev.next = newNode;
				}
				newNode.prev = tempHead.prev;
				tempHead.prev = newNode;
				newNode.next = tempHead;
			}
			return headNode;
		}
	}
}
