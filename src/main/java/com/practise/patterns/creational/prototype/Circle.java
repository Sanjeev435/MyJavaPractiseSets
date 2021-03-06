package com.practise.patterns.creational.prototype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle extends Shape{
	
	private int radius;
	
	public Circle(Circle target) {
		super(target);
		if(target != null) {
			this.radius = target.radius;
		}
	}
	
	
	public Circle() {}


	@Override
	public Circle clone() {
		return new Circle(this);
	}
	
	@Override
	public boolean equals(Object target) {
		if(!(target instanceof Circle) || !super.equals(target)) {
			return false;
		}
		Circle circle = (Circle)target;
		return circle.radius == this.radius;
	}
	
	@Override
	public int hashCode() {
		int result = 31;
		result = 31 * result + this.radius;
		return result;
	}

}
