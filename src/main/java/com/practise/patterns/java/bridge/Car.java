package com.practise.patterns.java.bridge;

/**
 * This is a abstraction class.
 * 
 * The Car class which holds a reference of a product type and
 * provides two abstract methods produceProduct() and assemble().
 * 
 * @author Sanjeev
 *
 */
public abstract class Car {

	private final Product product;
	private final String carType;

	public Car(Product product, String carType) {
		this.product = product;
		this.carType = carType;
	}

	public abstract void assemble();

	public abstract void produceProduct();

	public void printDetails() {
		System.out.println("Car: " + carType + ", Product:"
				+ product.productName());
	}
}
