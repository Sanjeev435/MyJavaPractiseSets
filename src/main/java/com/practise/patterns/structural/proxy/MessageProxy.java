package com.practise.patterns.structural.proxy;

public class MessageProxy implements Message{
	private final Message message;
	
	public MessageProxy(Message message) {
		this.message = message;
	}

	@Override
	public String displayText() {
		return message.displayText();
	}

}
