package com.practise.patterns.java.bridge;

/**
 * The subclasses of the Car i.e. Motoren.class will provide the concrete and
 * specific implementation to the methods assemble() and produceProduct().
 * 
 * @author Sanjeev
 *
 */
public class Motoren extends Car {

	private final Product product;
	private final String carType;

	public Motoren(Product product, String carType) {
		super(product, carType);
		this.product = product;
		this.carType = carType;
	}

	@Override
	public void assemble() {
		System.out.println("Assembling " + product.productName() + " for "
				+ carType);
	}

	@Override
	public void produceProduct() {
		product.produce();
		System.out.println("Modifing product " + product.productName()
				+ " according to " + carType);
	}

}
