package com.practise.patterns.behavioral.strategy;

public class TwitterStrategy implements ISocialMediaStrategy {

	public String connectTo(String friendName) {
		return "Connecting with " + friendName + " through Twitter";
	}
}