package com.practise.patterns.creational.factory;

public class ResponseXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		return new ResponseXMLParser();
	}

}
