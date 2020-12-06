package com.practise.patterns.structural;

import org.junit.Assert;
import org.junit.Test;

import com.practise.patterns.structural.flyweight.CoffeeFactory;
import com.practise.patterns.structural.flyweight.CoffeeFlavour;
import com.practise.patterns.structural.flyweight.CoffeeLatteArt;
import com.practise.patterns.structural.flyweight.CoffeeShop;

public class FlyWeightPatternTest {

	@Test
	public void shouldTestObjectCreation() {
		CoffeeShop shop = new CoffeeShop();

		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.BARISTA_SWAG, 5);
		shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.FRENCH, 7);
		shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 1);
		shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.DISNEY, 3);
		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.CAT, 2);
		shop.takeOrder(CoffeeFlavour.ESPRESSO, CoffeeLatteArt.FISHBONE, 8);
		shop.takeOrder(CoffeeFlavour.AFFOGATO, CoffeeLatteArt.BARISTA_SWAG, 4);
		shop.takeOrder(CoffeeFlavour.CAPPUCCINO, CoffeeLatteArt.DISNEY, 10);
		shop.takeOrder(CoffeeFlavour.LATTE, CoffeeLatteArt.LITTLE_BUNNY, 6);
		shop.takeOrder(CoffeeFlavour.FRAPPUCCINO, CoffeeLatteArt.DISNEY, 9);

		Assert.assertEquals(10, CoffeeShop.getNumberOfOrders());
		Assert.assertEquals(5, CoffeeFactory.getNumberOfCoffee());
	}

}
