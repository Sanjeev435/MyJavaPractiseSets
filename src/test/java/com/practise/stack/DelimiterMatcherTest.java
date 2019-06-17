package com.practise.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * The delimiters are the braces { and }, brackets [ and ], and parentheses (
 * and ). Each opening or left delimiter should be matched by a closing or right
 * delimiter; that is, every { should be followed by a matching } and so on.
 * 
 * @author Sanjeev
 *
 */
public class DelimiterMatcherTest {

	private static String correctSequence = "a{b(c[d]e)f}";
	
	private static String inCorrectSequence = "a[b{c}d]e}";
	
	private static String openingBraces = "[({";
	
	private static String closingBraces = "})]";
	
	@SuppressWarnings("deprecation")
	@Test
	public void testDelimiterMatcher() throws Exception {
		
		Integer errorPlaceHolder = validateDelimiter(correctSequence);
		Assert.assertEquals(new Integer(-1), errorPlaceHolder);
		
		Integer errorPlaceHolder1 = validateDelimiter(inCorrectSequence);
		Assert.assertEquals(new Integer(10), errorPlaceHolder1);
	}
	
	private static Integer validateDelimiter(String sequence) throws Exception{
		Stack<String> myCustomStack = new StackWithArray<String>(20);
		int count = 0;
		int errorPlaceHolder = -1;
		
		for(String str : sequence.split("")) {
			
			if(openingBraces.contains(str)) {
				myCustomStack.push(str);
			}
			else if(closingBraces.contains(str)) {
				if(myCustomStack.isEmpty()) {
					errorPlaceHolder = count+1;
					break;
				}else if(isCharMatchesDelimiter(myCustomStack, str)) {
					myCustomStack.pop();
				}else {
					errorPlaceHolder = count+1;
					break;
				}
			}
			count++;
		}
		
		return errorPlaceHolder;
	}

	private static boolean isCharMatchesDelimiter(Stack<String> myCustomStack, String str) throws Exception {
		return str.equals("}") && myCustomStack.peek().equals("{")
				|| str.equals("]") && myCustomStack.peek().equals("[")
				|| str.equals(")") && myCustomStack.peek().equals("(");
	}
	
}
