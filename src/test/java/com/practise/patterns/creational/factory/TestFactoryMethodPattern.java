package com.practise.patterns.creational.factory;

import org.junit.Assert;
import org.junit.Test;

/**
 * In the below class, we can clearly see that the by letting the subclasses to
 * implement the factory method creates the different instances of parsers which
 * can be used at runtime according to the need.
 * 
 * @author Sanjeev
 *
 */
public class TestFactoryMethodPattern {
	
	@Test
	public void shouldTestFactoryObjectCreation() {
		DisplayService service = new FeedbackXMLDisplayService();
		Assert.assertEquals(service.display(), "Feedback XML Message");

		service = new ErrorXMLDisplayService();
		Assert.assertEquals(service.display(), "Error XML Message");

		service = new OrderXMLDisplayService();
		Assert.assertEquals(service.display(), "Order XML Message");

		service = new ResponseXMLDisplayService();
		Assert.assertEquals(service.display(), "Response XML Message");
	}


}
