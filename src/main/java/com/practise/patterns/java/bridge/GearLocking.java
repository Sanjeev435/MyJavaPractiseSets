package com.practise.patterns.java.bridge;

/**
 * This is a concrete implementor class.
 * 
 * This concrete implementers provide implementation to the Product implementer.
 * 
 * @author Sanjeev
 *
 */
public class GearLocking implements Product {

	private final String productName;

	public GearLocking(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Gear Locking System");
	}

}
