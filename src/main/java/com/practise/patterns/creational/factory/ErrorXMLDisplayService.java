package com.practise.patterns.creational.factory;

public class ErrorXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		return new ErrorXMLParser();
	}

}
