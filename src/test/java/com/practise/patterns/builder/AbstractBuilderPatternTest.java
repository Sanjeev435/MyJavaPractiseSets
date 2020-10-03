package com.practise.patterns.builder;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.practise.patterns.builder.NewYorkPizza.SIZE;
import com.practise.patterns.builder.PizzaAbstractBuilder.Topping;

public class AbstractBuilderPatternTest {
	
	@Test
	public void shouldCreateObject() {
		NewYorkPizza nyPizza = new NewYorkPizza.NewYorkPizzaBuilder()
				.size(SIZE.SMALL)
				.addTopping(Topping.CHICKEN)
				.addTopping(Topping.SAUSAGE)
				.build();
		
		Assert.assertEquals(nyPizza.getSize(), SIZE.SMALL);
		Assert.assertEquals(new ArrayList<>(nyPizza.getToppings()), Arrays.asList(Topping.CHICKEN, Topping.SAUSAGE));
		
		CalzonePizza calzonPizza = new CalzonePizza.CalzonePizzaBuilder()
				.isSauceInsideNeeded(true)
				.addTopping(Topping.MUSHROOM)
				.addTopping(Topping.ONION)
				.build();
		
		Assert.assertEquals(calzonPizza.isSauceInsideNeeded(), true);
		Assert.assertEquals(new ArrayList<>(calzonPizza.getToppings()), Arrays.asList(Topping.MUSHROOM, Topping.ONION));
		
	}

}
