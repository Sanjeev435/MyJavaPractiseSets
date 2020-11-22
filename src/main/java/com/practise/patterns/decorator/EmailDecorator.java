package com.practise.patterns.decorator;

public abstract class EmailDecorator implements IEmail { 
	// wrapped component 
	IEmail originalEmail;
	
	public EmailDecorator(IEmail originalEmail) {
		super();
		this.originalEmail = originalEmail;
	}
}