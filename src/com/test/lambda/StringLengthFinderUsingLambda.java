package com.test.lambda;

@FunctionalInterface
interface StringLengthFinder {
	int getLength(String str);
}

@FunctionalInterface
interface AnotherStringLengthFinder {
	int getLength(String str1,String str2);
}

public class StringLengthFinderUsingLambda {

	public static void main(String[] args) {

		int length = 0;
		String str = "Hello World";
		
		//First way : proving Parameters and writing return statement.
		StringLengthFinder lengthFinder = (String string) -> {
			return string.length();
		};
		
		length = lengthFinder.getLength(str);		
		System.out.println("Length : "+length);
		
		//Second way : without curly braces and return statement
		lengthFinder = (String string) -> string.length();
		length = lengthFinder.getLength(str+" Extra");		
		System.out.println("Length : "+length);
		
		//Third way : by skipping input parameter's type
		
		lengthFinder = (string) -> string.length();
		length = lengthFinder.getLength(str);		
		System.out.println("Length : "+length);
		
		//Fourth way : skipping the parantheses
		lengthFinder = string -> string.length();
		length = lengthFinder.getLength(str);		
		System.out.println("Length : "+length);
		
		callGetLengthUsingLambda();
		
		
	}

	private static void callGetLengthUsingLambda() {
		
		String str1 = "Hello";
		String str2 = "World";
		int length = 0;
		
		//if we have more than one parameters, we need to
		//specify all the parameters in lambda expression.
		AnotherStringLengthFinder lengthFinder = (string1, string2)-> {
			return string1.length() + string2.length();
		};
		
		length = lengthFinder.getLength(str1, str2);
		System.out.println("Length : "+length);
		
		//removing parantheses : only works with single parameter
		//lengthFinder = String1,String2 -> string1.length() + string2.length();
		

	}

}
