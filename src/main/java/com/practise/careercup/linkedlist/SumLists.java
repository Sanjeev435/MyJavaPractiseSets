package com.practise.careercup.linkedlist;


/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Sum Lists:</b> You have two numbers represented by a linked list,
 *         where each node contains a single digit. The digits are stored in
 *         reverse order, such that the 1 's digit is at the head of the list.
 *         Write a function that adds the two numbers and returns the sum as a
 *         linked list. <br/>
 *         <b>Example Input:</b> (7-> 1 -> 6) + (5 -> 9 -> 2). That is, 617 +
 *         295. <br/>
 *         <b>Output:</b> 2 -> 1 -> 9. That is, 912. <br/>
 *         <br/>
 *         <b><u>FOLLOW UP</u></b> <br/>
 *         Suppose the digits are stored in forward order. Repeat the above
 *         problem.<br/>
 *         <b>Input:</b> (6 -> 1 -> 7) + (2 -> 9 -> 5). That is,617 + 295. <br/>
 *         <b>Output:</b> 9 -> 1 -> 2. That is, 912.<br/>
 *
 */
public class SumLists extends SinglyLinkedListHelper {

	public static void main(String[] args) {
		SumLists list = new SumLists();
		list.add(7);
		list.add(1);
		list.add(6);

		SumLists list1 = new SumLists();
		list1.add(5);
		list1.add(9);
		list1.add(7);

		// 617 + 795 = 912 -> [2, 1, 4, 1]
		System.out.println(list1.toNodeString(list1.addLists(list.head, list1.head)));
		System.out.println(list1.toNodeString(list1.addListsRecussive(list.head, list1.head, 0)));
	}
	
	public Node addListsRecussive(Node node1, Node node2, int carry) {
		if (node1 == null && node2 == null && carry == 0) {
			return null;
		}

		int sum = (node1 == null ? 0 : node1.data) + (node2 == null ? 0 : node2.data);

		Node nodeTemp = new Node((sum + carry) % 10);

		carry = (sum + carry) / 10;

		Node node = addListsRecussive(node1 == null ? null : node1.next,
				node2 == null ? null : node2.next, carry);
		if (node != null) {
			nodeTemp.next = node;
			node = nodeTemp;
		} else {
			node = nodeTemp;
		}

		return node;
	}

	public Node addLists(Node node1, Node node2) {
		int sum = 0;
		int count = 0;

		while (node1 != null || node2 != null) {
			double power = count == 0 ? 1 : Math.pow(10, count);

			if (node1 != null) {
				sum += node1.data * power;
				node1 = node1.next;
			}

			if (node2 != null) {
				sum += node2.data * power;
				node2 = node2.next;
			}
			count++;
		}

		count += 1;
		Node head = null;
		Node node = null;
		while (sum > 0) {
			Node tempNode = new Node(sum % 10);

			if (head != null) {
				node.next = tempNode;
				node = tempNode;
			} else {
				head = tempNode;
				node = tempNode;
			}
			sum = sum / 10;

			count--;
		}

		return head;
	}
	
	public void addlistsFollowUp(Node node1, Node node2) {
		
	}

	/*
	 * public Node addLists(Node l1, Node l2) { int lenl = length(l1); int len2 =
	 * length(l2);
	 * 
	 * Pad the shorter list with zeros - see note (1) if (lenl < len2) { l1 =
	 * padList(l1, len2 - lenl); } else { l2 = padList(l2, lenl - len2); }
	 * 
	 * Add lists PartialSum sum = addListsHelper(l1, l2);
	 * 
	 * 
	 * If there was a carry value left over, insert this at the front of the list.
	 * Otherwise, just return the linked list.
	 * 
	 * if (sum.carry == 0) { return sum.sum; } else { Node result =
	 * insertBefore(sum.sum, sum.carry); return result; } }
	 * 
	 * int length(Node node) { int count = 0;
	 * 
	 * while(node != null) { node = node.next; count +=1; } return count; }
	 * 
	 * PartialSum addListsHelper(Node l1, Node l2) { if (l1 == null && l2 == null) {
	 * PartialSum sum = new PartialSum(); return sum; } Add smaller digits
	 * recursively PartialSum sum = addListsHelper(l1.next, l2.next);
	 * 
	 * Add carry to current data int val = sum.carry + l1.data + l2.data;
	 * 
	 * Insert sum of current digits Node full_result = insertBefore(sum.sum, val %
	 * 10);
	 * 
	 * Return sum so far, and the carry value sum.sum = full_result; sum.carry = val
	 * / 10; return sum; }
	 * 
	 * Pad the list with zeros Node padList(Node l, int padding) { Node head = l;
	 * for (int i = 0; i < padding; i++) { head = insertBefore(head, 0); } return
	 * head; }
	 * 
	 * Helper function to insert node in the front of a linked list Node
	 * insertBefore(Node list, int data) { Node node = new Node(data); if (list !=
	 * null) { node.next = list; } return node; }
	 * 
	 * static class PartialSum { public Node sum = null; public int carry = 0; }
	 */
}
