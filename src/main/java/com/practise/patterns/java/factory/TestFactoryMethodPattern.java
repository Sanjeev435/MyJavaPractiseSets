package com.practise.patterns.java.factory;

/**
 * In the below class, we can clearly see that the by letting the subclasses to
 * implement the factory method creates the different instances of parsers which
 * can be used at runtime according to the need.
 * 
 * @author Sanjeev
 *
 */
public class TestFactoryMethodPattern {

	public static void main(String[] args) {
		DisplayService service = new FeedbackXMLDisplayService();
		service.display();

		service = new ErrorXMLDisplayService();
		service.display();

		service = new OrderXMLDisplayService();
		service.display();

		service = new ResponseXMLDisplayService();
		service.display();

	}

}
