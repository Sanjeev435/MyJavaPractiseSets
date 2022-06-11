package com.practise.careercup.linkedlist;

import org.junit.Assert;
import org.junit.Test;



public class SumListsTest {
	
	@Test
	public void testListSumReverseOrderPrint() {
		SumLists list = new SumLists();
		list.add(7);
		list.add(1);
		list.add(9);

		SumLists list1 = new SumLists();
		list1.add(5);
		list1.add(9);
		list1.add(2);
		
		Assert.assertEquals(list1.toNodeString(list1.addLists(list.head, list1.head)), "[2, 1, 2, 1]");
		Assert.assertEquals(list1.toNodeString(list1.addListsRecussive(list.head, list1.head, 0)), "[2, 1, 2, 1]");
		
		list = new SumLists();
		list.add(7);
		list.add(1);
		list.add(3);
		
		list1 = new SumLists();
		list1.add(5);
		list1.add(9);
		list1.add(2);
		Assert.assertEquals(list1.toNodeString(list1.addLists(list.head, list1.head)), "[2, 1, 6]");
		Assert.assertEquals(list1.toNodeString(list1.addListsRecussive(list.head, list1.head, 0)), "[2, 1, 6]");
		
		list = new SumLists();
		list.add(9);
		list.add(1);
		list.add(3);
		list.add(8);
		
		list1 = new SumLists();
		list1.add(5);
		list1.add(9);
		list1.add(8);
		Assert.assertEquals(list1.toNodeString(list1.addLists(list.head, list1.head)), "[4, 1, 2, 9]");
		Assert.assertEquals(list1.toNodeString(list1.addListsRecussive(list.head, list1.head, 0)), "[4, 1, 2, 9]");
	}

}
