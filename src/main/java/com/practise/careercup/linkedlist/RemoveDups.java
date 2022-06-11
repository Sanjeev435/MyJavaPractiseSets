package com.practise.careercup.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Remove Duplicates : </b> Write code to remove duplicates from an
 *         unsorted linked list. <br/>
 *         <br/>
 *         <b>FOLLOW UP : </b><br/>
 *         How would you solve this problem if a <b><i>temporary buffer is not
 *         allowed</i></b>?
 *
 */
public class RemoveDups extends SinglyLinkedListHelper {

	public static void main(String[] args) {
		RemoveDups list = new RemoveDups();
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(8);
		list.add(6);
		list.add(9);
		list.add(5);
		list.add(1);

		list.removeDuplicates();
		System.out.println(list.toString()); // 1, 5, 6, 8, 9

		RemoveDups list1 = new RemoveDups();
		list1.add(1);
		list1.add(5);
		list1.add(6);
		list1.add(8);
		list1.add(6);
		list1.add(9);
		list1.add(5);
		list1.add(1);

		list1.removeDupesWithoutTempBuff();
		System.out.println(list1.toString()); // 1, 5, 6, 8, 9
	}

	private void removeDuplicates() {
		Map<Integer, Integer> map = new HashMap<>();

		Node current = head;
		Node pre = null;
		while (current != null) {
			if (map.containsKey(current.data)) {
				pre.next = current.next;
			} else {
				pre = current;
				map.put(current.data, current.data);
			}

			current = current.next;
		}
	}

	private void removeDupesWithoutTempBuff() {
		Node current = head;
		while (current != null) {

			Node currentTemp = current;
			while (currentTemp.next != null) {
				if (current.data == currentTemp.next.data) {
					currentTemp.next = currentTemp.next.next;
				}else {
					currentTemp = currentTemp.next;
				}
			}
			current = current.next;
		}
	}
}
