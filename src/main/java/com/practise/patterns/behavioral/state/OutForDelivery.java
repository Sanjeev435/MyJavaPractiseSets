package com.practise.patterns.behavioral.state;

public class OutForDelivery implements PackageState {
	
	// Singleton
	private static OutForDelivery instance = new OutForDelivery();

	private OutForDelivery() {
	}

	public static OutForDelivery instance() {
		return instance;
	}

	// Business logic and state transition
	@Override
	public String updateState(DeliveryContext ctx) {
		ctx.setCurrentState(Delivered.instance());
		return "Package is out of delivery !!";
	}
}