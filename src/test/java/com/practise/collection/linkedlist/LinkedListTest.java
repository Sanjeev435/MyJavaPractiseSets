package com.practise.collection.linkedlist;

import org.junit.Assert;
import org.junit.Test;
import java.util.LinkedList;

public class LinkedListTest {

	/**
	 * Test Custom Linked List functionality with actal Linked List functionality;
	 */
	@Test
	public void testCustomLinkedList() {
		LinkedList<String> list = new LinkedList<>();
		list.add("Mohan");
		list.add("Raj");
		list.add("Kishore");
		list.add("Sanjeev");
		list.add("Akash");
		list.add("Vikash");
		list.add("Sanjeev");
		list.add("Asha");

		Assert.assertEquals(list.get(4), "Akash");
		Assert.assertEquals(list.indexOf("Rohan"), -1);
		Assert.assertEquals(list.indexOf("Asha"), 7);
		Assert.assertEquals(list.element(), "Mohan");
		Assert.assertEquals(list.indexOf("Sanjeev"), 3);

		Assert.assertTrue(list.offer("Rajesh"));
		Assert.assertEquals(list.indexOf("Rajesh"), 8);

		Assert.assertEquals(list.peek(), "Mohan");
		Assert.assertEquals(list.size(), 9);

		Assert.assertEquals(list.remove(5), "Vikash");
		Assert.assertEquals(list.peek(), "Mohan");
		Assert.assertEquals(list.size(), 8);

		Assert.assertEquals(list.poll(), "Mohan");
		Assert.assertEquals(list.peek(), "Raj");
		Assert.assertEquals(list.size(), 7);
		
		Assert.assertEquals(list.remove(), "Raj");
		Assert.assertEquals(list.peek(), "Kishore");
		Assert.assertEquals(list.size(), 6);

		// Custom list functions

		com.practise.collection.linkedlist.LinkedList<String> customlist = 
				new com.practise.collection.linkedlist.LinkedList<>();

		customlist.add("Mohan");
		customlist.add("Raj");
		customlist.add("Kishore");
		customlist.add("Sanjeev");
		customlist.add("Akash");
		customlist.add("Vikash");
		customlist.add("Sanjeev");
		customlist.add("Asha");

		Assert.assertEquals(customlist.get(4), "Akash");
		Assert.assertEquals(customlist.indexOf("Rohan"), -1);
		Assert.assertEquals(customlist.indexOf("Asha"), 7);
		Assert.assertEquals(customlist.element(), "Mohan");
		Assert.assertEquals(customlist.indexOf("Sanjeev"), 3);

		Assert.assertTrue(customlist.offer("Rajesh"));
		Assert.assertEquals(customlist.indexOf("Rajesh"), 8);

		Assert.assertEquals(customlist.peek(), "Mohan");
		Assert.assertEquals(customlist.size(), 9);
		
		Assert.assertEquals(customlist.remove(5), "Vikash");
		Assert.assertEquals(customlist.peek(), "Mohan");
		Assert.assertEquals(customlist.size(), 8);

		Assert.assertEquals(customlist.poll(), "Mohan");
		Assert.assertEquals(customlist.peek(), "Raj");
		Assert.assertEquals(customlist.size(), 7);
		
		Assert.assertEquals(customlist.remove(), "Raj");
		Assert.assertEquals(customlist.peek(), "Kishore");
		Assert.assertEquals(customlist.size(), 6);
	}
}
