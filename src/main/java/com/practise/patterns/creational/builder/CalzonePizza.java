package com.practise.patterns.creational.builder;

public class CalzonePizza extends PizzaAbstractBuilder{
	
	private final boolean isSauceInsideNeeded;
	
	private CalzonePizza(CalzonePizzaBuilder builder) {
		super(builder);
		this.isSauceInsideNeeded = builder.isSauceInsideNeeded;
	}
	
	public boolean isSauceInsideNeeded() {
		return this.isSauceInsideNeeded;
	}
	
	public static class CalzonePizzaBuilder extends PizzaAbstractBuilder.Builder<CalzonePizzaBuilder>{
		
		private boolean isSauceInsideNeeded;
		
		public CalzonePizzaBuilder isSauceInsideNeeded(boolean isSauceInsideNeeded) {
			this.isSauceInsideNeeded = isSauceInsideNeeded;
			return this;
		}
		
		@Override
		public CalzonePizza build() {
			return new CalzonePizza(this);
		}
		
		@Override
		protected CalzonePizzaBuilder self() {
			return this;
		}
		
	}

}
