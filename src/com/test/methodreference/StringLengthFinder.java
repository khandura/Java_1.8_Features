package com.test.methodreference;

@FunctionalInterface
interface StringLengthFinderInterface {
	int findLength(String string);
}

public class StringLengthFinder {
	
	public static void findStringLength(String string) {
		
		StringLengthFinderInterface finder = String::length;		
		int length = finder.findLength(string);
		System.out.println("String <"+ string +"> length : "+length);
	}

	public static void main(String[] args) {
		
		findStringLength("Hello");

	}

}
