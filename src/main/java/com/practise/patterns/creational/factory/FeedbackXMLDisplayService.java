package com.practise.patterns.creational.factory;

public class FeedbackXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		return new FeedbackXML();
	}

}