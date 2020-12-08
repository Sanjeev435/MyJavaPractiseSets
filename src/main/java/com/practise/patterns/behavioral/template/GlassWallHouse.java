package com.practise.patterns.behavioral.template;

public class GlassWallHouse extends House {

	@Override
	public String decorateHouse() {
		return "Decorating Glass Wall House";
	}

	@Override
	public String paintHouse() {
		return "Painting Glass Wall House";
	}

	@Override
	public String constructDoors() {
		return "Constructing Doors for Glass Wall House";
	}

	@Override
	public String constructWindows() {
		return "Constructing Windows for Glass Wall House";
	}

	@Override
	public String constructWalls() {
		return "Constructing Glass Wall for my House";
	}
}