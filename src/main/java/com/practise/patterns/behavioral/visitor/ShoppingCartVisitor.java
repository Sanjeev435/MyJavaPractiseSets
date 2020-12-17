package com.practise.patterns.behavioral.visitor;

/**
 * @author Sanjeev Kumar
 * 
 *         We have visit() method for different type of items in Visitor
 *         interface that will be implemented by concrete visitor class.
 */
public interface ShoppingCartVisitor {

	int visit(Book book);

	int visit(Fruit fruit);
}
