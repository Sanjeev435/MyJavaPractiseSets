package com.practise.patterns.behavioral.state;

public class Delivered implements PackageState {
	
	// Singleton
	private static Delivered instance = new Delivered();

	private Delivered() {
	}

	public static Delivered instance() {
		return instance;
	}

	// Business logic
	@Override
	public String updateState(DeliveryContext ctx) {
		return "Package is delivered!!";
	}
}
