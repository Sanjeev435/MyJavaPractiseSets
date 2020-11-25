package com.practise.patterns.creational.builder;

import java.util.EnumSet;
import java.util.Set;

public abstract class PizzaAbstractBuilder {
	
	public enum Topping { CHICKEN, MUSHROOM, ONION, PEPPER, SAUSAGE }
	final Set<Topping> toppings;
	
	public PizzaAbstractBuilder(Builder<?> builder) {
		toppings = builder.toppings.clone();
	}
	
	public Set<Topping> getToppings() {
		return this.toppings;
	}
	
	 abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping) {
			toppings.add(topping);
			return self();
		}
		
		abstract PizzaAbstractBuilder build();
		
		// Subclasses must override this method to return "this"
		protected abstract T self();
	}

}
