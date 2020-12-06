package com.practise.patterns.structural.proxy;

public class MessageImpl implements Message {
	String message;
	
	public MessageImpl(String message) {
		this.message = message;
	}

	public String displayText() {
		return this.message;
	}
}
