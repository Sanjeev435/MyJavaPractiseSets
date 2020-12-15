package com.practise.patterns.behavioral.state;

public class InTransition implements PackageState {
	
	// Singleton
	private static InTransition instance = new InTransition();

	private InTransition() {
	}

	public static InTransition instance() {
		return instance;
	}

	// Business logic and state transition
	@Override
	public String updateState(DeliveryContext ctx) {
		ctx.setCurrentState(OutForDelivery.instance());
		return "Package is in transition !!";
	}
}
