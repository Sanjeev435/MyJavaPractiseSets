package com.practise.patterns.behavioral.visitor;

/**
 * @author Sanjeev Kumar
 * 
 *         Notice that accept method takes Visitor argument. We can have some
 *         other methods also specific for items but for simplicity we are not
 *         going into that much detail and focusing on visitor pattern only.
 */
public interface ItemElement {
	public int accept(ShoppingCartVisitor visitor);
}
