package com.practise.patterns.structural.flyweight;

public class Coffee {

	protected final CoffeeFlavour flavourName; // intrinsic attribute

	protected Coffee(CoffeeFlavour flavourName) {
		super();
		this.flavourName = flavourName;
	}

	public CoffeeFlavour getFlavourName() {
		return flavourName;
	}

	protected CoffeeLatteArt applyLatteArt(CoffeeLatteArt latteArt) {
		// CoffeeLatteArt latteArt will be act as extrinsic attribute
		// So, that will be required in creating and processing of Coffee object as
		// method parameters and will not be stored as class members.
		return latteArt;
	}
}
