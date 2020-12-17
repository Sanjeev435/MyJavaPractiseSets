package com.practise.patterns.behavioral.visitor;

import lombok.Getter;

/**
 * @author Sanjeev Kumar
 * 
 *         Concrete class for different types of items. Notice the
 *         implementation of accept() method in concrete classes, its calling
 *         visit() method of Visitor and passing itself as argument.
 */
@Getter
public class Fruit implements ItemElement {

	private int pricePerKg;
	private int weight;
	private String name;

	public Fruit(int priceKg, int wt, String nm) {
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
