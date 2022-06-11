package com.practise.careercup.linkedlist;


/**
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Merge two sorted linked list : </b> Given two sorted linked lists,
 *         merge them so that the resulting linked list is also sorted. Consider
 *         two sorted linked lists and the merged list below them as an example
 *         <br/>
 *         List  : 1 -> 4 -> 8 -> 15 -> 19
 *         List  : 2 -> 7 -> 9 -> 10 -> 16
 *         Final merged list - 1 -> 2 -> 4 -> 7 -> 8 -> 9 -> 10 -> 15 -> 16 -> 19
 *
 */
public class MergeSortedList extends SinglyLinkedListHelper{
	
	MergeSortedList(){
		super();
	}
	
	public static void main(String[] args) {
		MergeSortedList list = new MergeSortedList();
		list.add(1);
		list.add(4);
		list.add(8);
		list.add(15);
		list.add(19);
		
		MergeSortedList list1 = new MergeSortedList();
		list1.add(2);
		list1.add(7);
		list1.add(9);
		list1.add(10);
		list1.add(16);
		
		System.out.println(mergeSortedList(list, list1).toString());
	}

	public static MergeSortedList mergeSortedList(MergeSortedList list, MergeSortedList list1){
		if(list.head == null || list1.head == null) {
			return list.head == null ? list1 : list;
		}
		
		Node node = list.head;
		Node node1 = list1.head;
		Node pre = null;
		
		while(node1 != null) {
			if(node1.data > node.data) {
				Node temp = node; // temp = 1
				node = node.next; //4
				
				if(pre != null) {
					pre.next = temp;
					temp.next = node1;
				}else {
					temp.next = node1; // 1 -> 2 - 7
				}
				node1 = temp;  // 1 -> 2 - 7
				pre = temp;
			}else {
				node1 = node1.next;
			}
		}
		
		list1.head = node1;
		
		return list1;
	}

}
