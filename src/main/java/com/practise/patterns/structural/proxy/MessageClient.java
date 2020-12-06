package com.practise.patterns.structural.proxy;

public class MessageClient {
	
	public static void main(String[] args) {
		Message message = new MessageImpl("Test Proxy Client");
		
		// Create a proxy Object
		Message messageProxy = new MessageProxy(message);
		System.out.println(messageProxy.displayText());
	}

}
