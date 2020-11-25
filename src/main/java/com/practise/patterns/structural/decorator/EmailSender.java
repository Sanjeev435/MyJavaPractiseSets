package com.practise.patterns.structural.decorator;

public class EmailSender {
	public void sendEmail(IEmail email) {
		// read the email to-address, to see if it's going outside of the company
		// if so decorate it
		ExternalEmailDecorator external = new ExternalEmailDecorator(email);
		external.getContents(); // send
	}
}
