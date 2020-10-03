package com.practise.patterns.factoryAbstract;

public interface AbstractParserFactory {

	public XMLParser getParserInstance(String parserType);
}
