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
public class Book implements ItemElement {

	private int price;
	private String isbnNumber;

	public Book(int cost, String isbn) {
		this.price = cost;
		this.isbnNumber = isbn;
	}

	@Override
	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}

}