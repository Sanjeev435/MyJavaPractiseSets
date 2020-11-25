package com.practise.patterns.creational.factory;

public class OrderXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		return new OrderXMLParser();
	}

}
