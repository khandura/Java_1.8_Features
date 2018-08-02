package com.test.functionalinterface;

@FunctionalInterface
public interface MyProcessor<T> {
	
	void process(T t);

}
