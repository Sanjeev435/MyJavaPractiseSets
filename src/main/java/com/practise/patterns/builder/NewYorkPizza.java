package com.practise.patterns.builder;

public class NewYorkPizza extends PizzaAbstractBuilder {
	
	public enum SIZE { SMALL, MEDIUM, LARGE};
	private final SIZE size;

	private NewYorkPizza(NewYorkPizzaBuilder builder) {
		super(builder);
		this.size = builder.size;
	}
	
	public SIZE getSize() {
		return this.size;
	}
	
	public static class NewYorkPizzaBuilder extends PizzaAbstractBuilder.Builder<NewYorkPizzaBuilder>{
		private SIZE size;
		
		public NewYorkPizzaBuilder size(SIZE size) {
			this.size = size;
			return this;
		}
		
		@Override
		public NewYorkPizza build() {
			return new NewYorkPizza(this);
		}
		
		@Override
		protected NewYorkPizzaBuilder self() {
			return this;
		}
	}
}
