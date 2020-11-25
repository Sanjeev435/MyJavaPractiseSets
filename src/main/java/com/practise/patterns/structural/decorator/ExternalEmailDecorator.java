package com.practise.patterns.structural.decorator;

//concrete decorator
// For e.g: e-mails that leave the company internal server need to have a disclaimer added to the end. 
// We can just add in a decorator to handle this.
public class ExternalEmailDecorator extends EmailDecorator {
	private String content;

	public ExternalEmailDecorator(IEmail basicEmail) {
		super(basicEmail);
	}

	@Override
	public String getContents() {
		// secure original
		content = addDisclaimer(originalEmail.getContents());
		return content;
	}

	private String addDisclaimer(String message) {
		// append company disclaimer to message
		return message + "\n Company Disclaimer";
	}
}
