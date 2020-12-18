package com.practise.patterns.behavioral.strategy;

public class FacebookStrategy implements ISocialMediaStrategy {

	public String connectTo(String friendName) {
		return "Connecting with " + friendName + " through Facebook";
	}
}
