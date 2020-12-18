package com.practise.patterns.behavioral.strategy;

public class SocialMediaContext {
	ISocialMediaStrategy smStrategy;

	public void setSocialmediaStrategy(ISocialMediaStrategy smStrategy) {
		this.smStrategy = smStrategy;
	}

	public String connect(String name) {
		return smStrategy.connectTo(name);
	}
}