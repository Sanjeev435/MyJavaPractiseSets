package com.practise.patterns.java.bridge;

/**
 * This is a concrete implementor class.
 * 
 * This concrete implementers provide implementation to the Product implementer.
 * 
 * @author Sanjeev
 *
 */
public class CentralLocking implements Product {

	private final String productName;

	public CentralLocking(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Central Locking System");
	}

}
