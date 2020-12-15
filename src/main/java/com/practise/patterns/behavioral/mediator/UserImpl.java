package com.practise.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sanjeev Kumar
 * 
 *         Mediator Design Pattern Concrete Colleague : concrete User classes to
 *         be used by client system. Notice that send() method is using mediator
 *         to send the message to the users and it has no idea how it will be
 *         handled by the mediator.
 */
public class UserImpl extends User {

	public UserImpl(ChatMediator med, String name) {
		super(med, name);
	}

	@Override
	public List<String> send(String msg) {
		List<String> messages = new ArrayList<>(Arrays.asList(this.name + " : Sending Message : " + msg));
		messages.addAll(mediator.sendMessage(msg, this));
		return messages;
	}

	@Override
	public String receive(String msg) {
		return this.name + " : Received Message: " + msg;
	}

}
