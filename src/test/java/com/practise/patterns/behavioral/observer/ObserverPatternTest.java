package com.practise.patterns.behavioral.observer;

import org.junit.Assert;
import org.junit.Test;


public class ObserverPatternTest {

	@Test
	public void shouldTestObserverPattern() {
		Person arpitPerson = new Person("Sanjeev");
		Person johnPerson = new Person("John");

		Product samsungMobile = new Product("Samsung", "Mobile", "Not available");

		// When you opt for option "Notify me when product is available".Below
		// registerObserver method get executed
		samsungMobile.registerObserver(arpitPerson);
		samsungMobile.registerObserver(johnPerson);

		// Now product is available
		samsungMobile.setAvailability("Available");
		
		Assert.assertTrue(samsungMobile.isUsersNotified());
	}

}
