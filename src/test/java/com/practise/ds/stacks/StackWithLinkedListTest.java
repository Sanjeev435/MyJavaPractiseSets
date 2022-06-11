package com.practise.ds.stacks;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import com.practise.ds.stack.StackWithLinkedList;

public class StackWithLinkedListTest {

	@Test
	public void testStackApis() {
		Stack<Integer> stack = new Stack<>();

		Assert.assertTrue(stack.isEmpty());

		stack.push(0);
		stack.add(5);
		stack.add(2);
		stack.add(9);
		stack.push(7);
		stack.push(1);
		stack.push(8);
		stack.push(4);
		stack.push(6);
		stack.push(3);

		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(stack.size(), 10);

		Assert.assertEquals(stack.remove(2), new Integer(2));
		Assert.assertEquals(stack.size(), 9);
		Assert.assertEquals(stack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(stack.pop(), new Integer(3));
		Assert.assertEquals(stack.size(), 8);
		Assert.assertEquals(stack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6]");

		Assert.assertEquals(stack.peek(), new Integer(6));
		Assert.assertEquals(stack.size(), 8);
		Assert.assertEquals(stack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6]");

		// Custom stack
		StackWithLinkedList customStack = new StackWithLinkedList();

		Assert.assertTrue(customStack.isEmpty());

		customStack.add(0);
		customStack.add(5);
		customStack.add(2);
		customStack.add(9);
		customStack.add(7);
		customStack.add(1);
		customStack.add(8);
		customStack.add(4);
		customStack.add(6);
		customStack.add(3);

		Assert.assertFalse(customStack.isEmpty());
		Assert.assertEquals(customStack.size(), 10);

		Assert.assertEquals(customStack.remove(2), 2);
		Assert.assertEquals(customStack.size(), 9);
		Assert.assertEquals(customStack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6, 3]");

		Assert.assertEquals(customStack.pop(), 3);
		Assert.assertEquals(customStack.size(), 8);
		Assert.assertEquals(customStack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6]");

		Assert.assertEquals(customStack.peek(), 6);
		Assert.assertEquals(customStack.size(), 8);
		Assert.assertEquals(customStack.toString(), "[0, 5, 9, 7, 1, 8, 4, 6]");

	}

	@Test
	public void testPop() {
		StackWithLinkedList customStack = new StackWithLinkedList();

		Assert.assertTrue(customStack.isEmpty());
		customStack.add(0);
		
		Assert.assertEquals(customStack.pop(), 0);
		Assert.assertEquals(customStack.size(), 0);
		Assert.assertEquals(customStack.toString(), "");

		customStack.add(0);
		customStack.add(5);
		
		Assert.assertEquals(customStack.pop(), 5);
		Assert.assertEquals(customStack.size(), 1);
		Assert.assertEquals(customStack.toString(), "[0]");
		
		customStack.add(4);
		customStack.add(6);
		customStack.add(3);
		Assert.assertEquals(customStack.pop(), 3);
		Assert.assertEquals(customStack.size(), 3);
		Assert.assertEquals(customStack.toString(), "[0, 4, 6]");

	}
	
	@Test
	public void testRemove() {
		StackWithLinkedList customStack = new StackWithLinkedList();

		Assert.assertTrue(customStack.isEmpty());
		customStack.add(0);
		
		Assert.assertEquals(customStack.remove(0), 0);
		Assert.assertEquals(customStack.size(), 0);
		Assert.assertEquals(customStack.toString(), "");

		customStack.add(0);
		customStack.add(5);
		
		Assert.assertEquals(customStack.remove(1), 5);
		Assert.assertEquals(customStack.size(), 1);
		Assert.assertEquals(customStack.peek(), 0);
		Assert.assertEquals(customStack.toString(), "[0]");
		
		customStack.add(4);
		customStack.add(6);
		customStack.add(3);
		
		Assert.assertEquals(customStack.remove(2), 6);
		Assert.assertEquals(customStack.size(), 3);
		Assert.assertEquals(customStack.peek(), 3);
		Assert.assertEquals(customStack.toString(), "[0, 4, 3]");
	}

}
