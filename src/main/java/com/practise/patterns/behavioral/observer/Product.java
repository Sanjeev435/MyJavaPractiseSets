package com.practise.patterns.behavioral.observer;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Sanjeev Kumar
 * 
 *         ConcreteSubject class
 *
 */
@Getter
@Setter
public class Product implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String productName;
	private String productType;
	private String availability;
	private boolean isUsersNotified; // This field is created for testing purpose.

	public Product(String productName, String productType, String availability) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.availability = availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		notifyObservers();
	}

	public void notifyObservers() {
		System.out.println("Notifying to all the subscribers when product became available");
		for (Observer ob : observers) {
			ob.update(this.availability);
			this.isUsersNotified = true;
		}
	}

	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

}