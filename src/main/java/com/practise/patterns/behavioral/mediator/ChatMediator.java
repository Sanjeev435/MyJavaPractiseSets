package com.practise.patterns.behavioral.mediator;

import java.util.List;

/**
 * @author Sanjeev Kumar
 * 
 *         Mediator interface that will define the contract for concrete
 *         mediators.
 */
public interface ChatMediator {
	
	public List<String> sendMessage(String msg, User user);

	void addUser(User user);
}
