package com.practise.patterns.behavioral.visitor;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

public class VisitorPatternTest {

	@Test
	public void shouldTestVisitorPattern() {

		ItemElement[] items = new ItemElement[] {
				new Book(20, "1234"),
				new Book(100, "5678"),
				new Fruit(10, 2, "Banana"),
				new Fruit(5, 5, "Apple")
				};
		
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		Integer totalValue = Stream.of(items).map(item -> item.accept(visitor)).reduce(Integer::sum).get();
		
		Assert.assertEquals(totalValue, new Integer(160));
	}

}
