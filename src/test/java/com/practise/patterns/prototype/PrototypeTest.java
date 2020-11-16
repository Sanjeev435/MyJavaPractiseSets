package com.practise.patterns.prototype;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class PrototypeTest {

	@Test
	public void shouldTestPrototypePattern() {
		List<Shape> shapes = getShapes();
		List<Shape> shapesCopy = new ArrayList<>();

		Assert.assertEquals(shapes.size(), 3);

		for (Shape shape : shapes) {
			shapesCopy.add(shape.clone());
		}
		
		Assert.assertEquals(shapesCopy.size(), 3);

		
		Assert.assertFalse(shapes.get(0) == shapesCopy.get(0));     // Shapes are different objects
		Assert.assertTrue(shapes.get(0).equals(shapesCopy.get(0))); // And yet they are identical
		
		Assert.assertFalse(shapes.get(1) == shapesCopy.get(1));
		Assert.assertTrue(shapes.get(1).equals(shapesCopy.get(1)));
		
		Assert.assertFalse(shapes.get(2) == shapesCopy.get(2));
		Assert.assertTrue(shapes.get(2).equals(shapesCopy.get(2)));
		
	}

	private List<Shape> getShapes() {
		List<Shape> shapes = new ArrayList<>();

		Circle circle = new Circle();
		circle.x = 10;
		circle.y = 20;
		circle.setRadius(15);
		circle.color = "red";
		shapes.add(circle);

		Circle anotherCircle = (Circle) circle.clone();
		shapes.add(anotherCircle);

		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(10);
		rectangle.setHeight(20);
		rectangle.color = "blue";
		shapes.add(rectangle);

		return shapes;
	}

}
