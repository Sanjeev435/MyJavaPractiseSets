package com.practise.patterns.behavioral.state;

public class Shipped implements PackageState {
	
	// Singleton
	private static Shipped instance = new Shipped();

	private Shipped() {
	}

	public static Shipped instance() {
		return instance;
	}

	// Business logic and state transition
	@Override
	public String updateState(DeliveryContext ctx) {
		ctx.setCurrentState(InTransition.instance());
		return "Package is shipped !!";
	}
}
