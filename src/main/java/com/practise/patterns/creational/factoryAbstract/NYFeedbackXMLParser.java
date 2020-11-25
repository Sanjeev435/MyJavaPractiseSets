package com.practise.patterns.creational.factoryAbstract;

public class NYFeedbackXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("NY Parsing feedback XML...");
		return "NY Feedback XML Message";
	}

}

