package com.practise.careercup.linkedlist;

public class ReverseLinkedList extends DoublyLinkedListHelper {

	public static void main(String[] args) {

		ReverseLinkedList list = new ReverseLinkedList();

		list.add(1);
		list.add(3);
		list.add(4);
		list.add(10);
		System.out.println(list.toNodeString(list.reverse()));
	}

	/*
	 * Complete the 'reverse' function below.
	 *
	 * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST. The
	 * function accepts INTEGER_DOUBLY_LINKED_LIST llist as parameter.
	 */
	public Node reverse() {
		Node list = head;

		Node temp = list;
		Node newHead = list;
		while (temp != null) {
			Node prev = temp.prev;
			temp.prev = temp.next;
			temp.next = prev;
			newHead = temp;
			temp = temp.prev;
		}
		return newHead;
	}
}
