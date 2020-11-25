package com.practise.patterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle extends Shape{
	
	private int width;
	private int height;
	
	public Rectangle() {}
	
	public Rectangle(Rectangle rectangle){
		super(rectangle);
		if(rectangle != null) {
			this.width = rectangle.width;
			this.height = rectangle.height;
		}
	}
	
	@Override
	public Rectangle clone() {
		return new Rectangle(this);
	}
	
	@Override
	public boolean equals(Object target) {
		if(!(target instanceof Rectangle) || !super.equals(target)){
			return false;
		}
		
		Rectangle rectangle = (Rectangle)target;
		return rectangle.width == this.width && rectangle.height == this.height;
	}

}
