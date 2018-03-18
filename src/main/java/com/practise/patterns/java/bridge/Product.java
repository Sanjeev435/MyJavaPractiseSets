package com.practise.patterns.java.bridge;

/**
 * This is a implementor class.
 * 
 * The implementer Product has a method produce() which will be used by the
 * concrete implementers to provide concrete functionality to it. The method
 * will produce the base model of the product which can be used with any car
 * model after some modifications specific to that car model.
 * 
 * @author Sanjeev
 *
 */
public interface Product {

	public String productName();

	public void produce();
}
