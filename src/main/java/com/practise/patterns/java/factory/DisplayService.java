package com.practise.patterns.java.factory;

/**
 * The below class is used to display the message fetched by the XML parser to
 * the user. The above class is an <b>abstract class</b> that contains two important
 * methods. The <b>display method</b> is used to display the message to the user. The
 * <b>getParser</b> method is the factory method which is implemented by the subclasses
 * to <b>instantiate the parser object</b> and the method is used by the <b>display</b> method
 * in order to <b>parse the XML</b> and gets the message to <b>display</b>.
 * 
 * @author Sanjeev
 *
 */
public abstract class DisplayService {

	public void display() {
		XMLParser parser = getParser();
		String msg = parser.parse();
		System.out.println(msg);
	}

	protected abstract XMLParser getParser();

}
