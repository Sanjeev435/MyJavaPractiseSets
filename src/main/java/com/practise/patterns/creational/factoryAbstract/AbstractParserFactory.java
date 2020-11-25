package com.practise.patterns.creational.factoryAbstract;

public interface AbstractParserFactory {

	public XMLParser getParserInstance(String parserType);
}
