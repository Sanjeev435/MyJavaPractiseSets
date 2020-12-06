package com.practise.patterns.behavioral.observer;

/**
 * @author Sanjeev Kumar
 * 
 *         Concrete Observers : This class is our ConcreteObserver class.It implements
 *         observer interface and provide implementation for update and other
 *         ConcreteObserver specific methods.
 */
public class Person implements Observer {

	String personName;

	public Person(String personName) {
		this.personName = personName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public void update(String availabiliy) {
		System.out.println("Hello " + personName + ", Product is now " + availabiliy + " on flipkart");
	}
}
