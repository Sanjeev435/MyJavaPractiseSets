package com.practise.patterns.behavioral.strategy;

public class GooglePlusStrategy implements ISocialMediaStrategy {

	public String connectTo(String friendName) {
		return "Connecting with " + friendName + " through GooglePlus";
	}
}