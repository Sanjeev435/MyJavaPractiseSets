package com.practise.patterns.java.factoryAbstract;

public interface AbstractParserFactory {

	public XMLParser getParserInstance(String parserType);
}
