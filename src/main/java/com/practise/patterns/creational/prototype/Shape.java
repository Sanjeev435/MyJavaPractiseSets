package com.practise.patterns.creational.prototype;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Shape {
	public int x;
	public int y;
	public String color;
	
	public Shape() {}

	public Shape(Shape target) {
		if (target != null) {
			this.x = target.x;
			this.y = target.y;
			this.color = target.color;
		}
	}

	public abstract Shape clone();

	@Override
	public String toString() {
		return "[ " + this.x + " , " + this.y + " , " + this.color + " ]";
	}

	@Override
	public boolean equals(Object shape) {
		if (!(shape instanceof Shape)) {
			return false;
		}
		Shape target = (Shape) shape;
		return this.x == target.x && this.y == target.y && Objects.equals(this.color, target.color);
	}

}
