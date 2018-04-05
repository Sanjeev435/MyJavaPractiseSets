package com.practise.stack;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldTestAllStackFunctionalities() throws Exception {
		
		Stack<Integer> stack = new Stack<Integer>(5);
		Assert.assertEquals(true, stack.isEmpty());
		
		stack.push(32);
		stack.push(45);
		stack.push(15);
		stack.push(66);
		stack.push(71);
		
		Assert.assertEquals(false, stack.isEmpty());
		Assert.assertEquals(true, stack.isFull());
		Assert.assertEquals(new Integer(71), stack.peek());
		stack.pop();
		Assert.assertEquals(false, stack.isFull());
		Assert.assertEquals(new Integer(66), stack.peek());
		
		int count = 0;
		
		while(!stack.isEmpty()) {
			stack.pop();
			count++;
		}
		Assert.assertEquals(new Integer(4), new Integer(count));
		Assert.assertEquals(true, stack.isEmpty());
		Assert.assertEquals(false, stack.isFull());
	}
	
	@Test
	public void ShouldThrowExceptionForEmptyStack() throws Exception {
		thrown.expect(IllegalAccessException.class);
        thrown.expectMessage("Stack is empty !!");
		
		Stack<Integer> stack = new Stack<Integer>(10);
		stack.pop();
	}
	
	@Test
	public void ShouldThrowExceptionForFullStack() throws Exception {
		thrown.expect(IllegalAccessException.class);
        thrown.expectMessage("Stack is full !!");
		
		Stack<Integer> stack = new Stack<Integer>(2);
		stack.push(2);
		stack.push(5);
		stack.push(9);
	}

}
