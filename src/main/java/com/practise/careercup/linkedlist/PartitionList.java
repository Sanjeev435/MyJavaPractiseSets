    package com.practise.careercup.linkedlist;

/**
 * 
 * @author Sanjeev Kumar
 * 
 * 
 *         <br/>
 *         <br/>
 *         <b>Partition:</b> Write code to partition a linked list around a
 *         value x, such that all nodes less than x come before all nodes
 *         greater than or equal to x. If x is contained within the list the
 *         values of x only need to be after the elements less than x (see
 *         below). The partition element x can appear anywhere in the "right
 *         partition"; it does not need to appear between the left and right
 *         partitions. <br/>
 *         <b>EXAMPLE Input:</b> 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 <br/>
 *         <b>[partition= 5]</b><br/>
 *         <b>Output:</b> 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 *
 */
public class PartitionList extends SinglyLinkedListHelper {

	public static void main(String[] args) {

		PartitionList list = new PartitionList();
		list.add(1);
		list.add(7);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(9);
		list.add(3);
		list.partition2(6);
		System.out.println(list.toString());
	}

	// 1, 7, 5, 6, 8, 9, 3
	public Node partition(int value) {
		Node smaller = null;
		Node greater = null;
		Node node = head;

		Node greaterHead = null;
		Node smallerHead = null;

		while (node != null) {
			if (node.data < value) {
				if (smaller != null) {
					smaller.next = node;
					smaller = smaller.next;
				} else {
					smaller = node;
					smallerHead = smaller;
				}
			} else {
				if (greater != null) {
					greater.next = node;
					greater = greater.next;
				} else {
					greater = node;
					greaterHead = greater;
				}
			}
			node = node.next;
		}

		if (greater != null) {
			greater.next = null;
		}

		smaller.next = greaterHead;

		return smallerHead;
	}

	// 1, 7, 5, 6, 8, 9, 3
	public void partition2(int value) {
		Node h = head;
		Node tail = head;
		Node node = head;

		while (node != null) {
			Node nodeNext = node.next;
			if (node.data < value) {
				node.next = h;
				h = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = nodeNext;
		}

		if (tail != null) {
			tail.next = null;
		}

		this.head = h;
	}
}
