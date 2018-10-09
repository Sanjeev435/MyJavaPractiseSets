package com.practise.stack;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test reversing a String using custom made Stack.class
 * 
 * @author Sanjeev
 *
 */
public class ReverseWordTest {
	
	private static String testString = "reverse me!!";

	@Test
	public void reverserWordWithStack() throws Exception {
		Stack<String> myCustomStack = new StackWithArray<String>(20);
		
		for(String str : testString.split(StringUtils.EMPTY)) {
			myCustomStack.push(str);
		}
	
		StringBuffer sb = new StringBuffer();
		while(!myCustomStack.isEmpty()) {
			sb.append(myCustomStack.pop());
		}
		
		Assert.assertEquals("!!em esrever", sb.toString());
	}
}
