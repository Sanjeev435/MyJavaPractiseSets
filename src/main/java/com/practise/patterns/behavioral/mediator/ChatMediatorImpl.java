package com.practise.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjeev Kumar
 * 
 *         Concrete Mediator : it will have a list of users in the group and
 *         provide logic for the communication between the users.
 *
 */
public class ChatMediatorImpl implements ChatMediator {

	private List<User> users;

	public ChatMediatorImpl() {
		this.users = new ArrayList<>();
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

	@Override
	public List<String> sendMessage(String msg, User user) {
		List<String> messages = new ArrayList<>();
		for (User u : this.users) {
			// message should not be received by the user sending it
			if (u != user) {
				messages.add(u.receive(msg));
			}
		}
		
		return messages;
	}

}
