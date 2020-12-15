package com.practise.patterns.behavioral.state;

public class Acknowledged implements PackageState {

	// Singleton
	private static Acknowledged instance = new Acknowledged();

	private Acknowledged() {
	}

	public static Acknowledged instance() {
		return instance;
	}

	// Business logic and state transition
	@Override
	public String updateState(DeliveryContext ctx) {
		ctx.setCurrentState(Shipped.instance());
		return "Package is acknowledged !!";
	}
}