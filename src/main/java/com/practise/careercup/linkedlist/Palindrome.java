package com.practise.careercup.linkedlist;

import java.util.Stack;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         <br/>
 *         <br/>
 *         <b>Palindrome:</b> Implement a function to check if a linked list is
 *         a palindrome. Since its a palindrome, the list must be the same
 *         backwards and forwards.<br/><br/>
 *         <b>Example Input:</b> 0 - > 1 - > 2 - > 1 - > 0. <br/>
 *
 * 
 */
public class Palindrome extends SinglyLinkedListHelper{
	
	public static void main(String[] args) {
		Palindrome palindrome = new Palindrome();
		palindrome.add(0);
		palindrome.add(1);
	//	palindrome.add(2);
	//	palindrome.add(1);
		palindrome.add(0);
		
		System.out.println(palindrome.isPalindromeUsingReverseApproch(palindrome.head)); // true
		System.out.println(palindrome.isPalindromeUsingIterativeApproch(palindrome.head)); // true
	}
	
	public boolean isPalindromeUsingReverseApproch(Node mainList) {
		Node tempList = mainList;
		Node head = null;
		
		while(mainList != null) {
			Node node = new Node(mainList.data);
			node.next = head;
			head = node;
			
			mainList = mainList.next;
		}
		
		while(tempList != null) {
			if(head.data != tempList.data) {
				return false;
			}
			head = head.next;
			tempList = tempList.next;
		}
		
		return true;
	}
	
	public boolean isPalindromeUsingIterativeApproch(Node mainList) {
		Stack<Integer> stack = new Stack<>();
		Node fastList = mainList;

		while (fastList.next != null) {
			stack.add(mainList.data);
			mainList = mainList.next;
			fastList = fastList.next.next;
		}
		
		stack.add(mainList.data);
		mainList = mainList.next;
		
		if(stack.size()%2 == 1) {
			stack.pop();
		}
		
		while(mainList != null) {
			if(stack.peek() != mainList.data) {
				return false;
			}else {
				stack.pop();
			}
			
			mainList = mainList.next;
		}

		return true;
	}

}
