package com.practise.patterns.behavioral.mediator;

import java.util.List;

/**
 * @author Sanjeev Kumar
 * 
 *         Mediator Pattern Colleague Interface : Users can send and receive
 *         messages, so we can have User interface or abstract class
 * 
 *         User has a reference to the mediator object, it’s required for the
 *         communication between different users.
 */
public abstract class User {
	protected ChatMediator mediator;
	protected String name;

	public User(ChatMediator med, String name) {
		this.mediator = med;
		this.name = name;
	}

	public abstract List<String> send(String msg);

	public abstract String receive(String msg);
}
