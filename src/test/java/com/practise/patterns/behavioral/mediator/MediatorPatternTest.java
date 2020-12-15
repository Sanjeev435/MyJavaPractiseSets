package com.practise.patterns.behavioral.mediator;

import java.util.List;

import org.junit.Test;

import org.junit.Assert;


public class MediatorPatternTest {


	@Test
	public void shouldTestMediatorPattern() {
		
		ChatMediator mediator = new ChatMediatorImpl();
		User user1 = new UserImpl(mediator, "Pankaj");
		User user2 = new UserImpl(mediator, "Lisa");
		User user3 = new UserImpl(mediator, "Saurabh");
		User user4 = new UserImpl(mediator, "David");
		mediator.addUser(user1);
		mediator.addUser(user2);
		mediator.addUser(user3);
		mediator.addUser(user4);
		
		List<String> messages = user1.send("Hi All");
		
		Assert.assertEquals(4, messages.size());
		Assert.assertEquals("Pankaj : Sending Message : Hi All", messages.get(0));
		Assert.assertEquals("Lisa : Received Message: Hi All", messages.get(1));
		Assert.assertEquals("Saurabh : Received Message: Hi All", messages.get(2));
		Assert.assertEquals("David : Received Message: Hi All", messages.get(3));
	}

	

}
