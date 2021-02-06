package com.practise.patterns.creational.factoryAbstract;

public interface AbstractParserFactory {

	XMLParser getParserInstance(String parserType);
}
