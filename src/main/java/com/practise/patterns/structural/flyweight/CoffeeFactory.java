package com.practise.patterns.structural.flyweight;

import java.util.WeakHashMap;
/**
 * 
 * @author Sanjeev Kumar
 * 
 * CoffeeFactory maintains a collection using CoffeeFlavour (intrinsic attribute) as key. This will help us reducing the 
 * number of objects created and reusing the existing one.
 *
 */
public class CoffeeFactory {
protected static WeakHashMap<CoffeeFlavour, Coffee> coffeeMap = new WeakHashMap<>();
	
	public static Coffee makeCoffee(CoffeeFlavour flavourName, CoffeeLatteArt latteArt) {
		Coffee coffee = coffeeMap.get(flavourName);
		if (coffee == null) {
			coffee = new Coffee(flavourName);
			coffeeMap.put(flavourName, coffee);
		}
		System.out.printf("Making '%s' with Latte Art '%s'.\n", coffee.getFlavourName(),
				coffee.applyLatteArt(latteArt));
		return coffee;
	}

	public static int getNumberOfCoffee() {
		return coffeeMap.size();
	}
}
