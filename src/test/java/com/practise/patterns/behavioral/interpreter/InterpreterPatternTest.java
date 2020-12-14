package com.practise.patterns.behavioral.interpreter;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;


public class InterpreterPatternTest {


	@Test
	public void shouldTestInterpreterPattern() {
		Expression intToBinaryExpression =  new IntToBinaryExpression(49);
		Assert.assertTrue(StringUtils.isNotEmpty(intToBinaryExpression.interpret(new InterpreterContext())));
		Assert.assertEquals("110001", intToBinaryExpression.interpret(new InterpreterContext()));
		
		Expression intToHexExpression =  new IntToHexExpression(28);
		Assert.assertTrue(StringUtils.isNotEmpty(intToHexExpression.interpret(new InterpreterContext())));
		Assert.assertEquals("1c", intToHexExpression.interpret(new InterpreterContext()));
	}

	

}
