package com.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaWrapperToHandleExceptionExample {

	public static void main(String[] args) {

	//	wrapperHandlingExceptionFunction();
	//	errorProneFunction();
		handleExceptionGenerically();

	}

	private static void handleExceptionGenerically() {
		
		List<String> names = Arrays.asList("Akhi", null, "Ram");

		System.out.println("isnide wrapperHandlingExceptionFunction");
		printNameSafely(names, consumerWrapper( name -> System.out.println(name.toUpperCase()) , NullPointerException.class ) );
		
	}

	private static void wrapperHandlingExceptionFunction() {

		List<String> names = Arrays.asList("Akhi", null, "Ram");

		System.out.println("isnide wrapperHandlingExceptionFunction");
		printNameSafely(names, nullPointHandler(name -> System.out.println(name.toUpperCase())));

	}

	private static void printNameSafely(List<String> names, Consumer<String> consumer) {

		System.out.println("isnide printNameSafely");
		names.forEach(consumer);

	}

	private static Consumer<String> nullPointHandler(Consumer<String> consumer) {

		System.out.println("inside nullPointHandler");

		return (name) -> {
			try {
				consumer.accept(name);
			} catch (NullPointerException e) {
				System.out.println("NullPointerException has occured : Provided String is : " + name);
			}
		};

	}

	private static void errorProneFunction() {

		List<String> names = Arrays.asList("Akhi", null, "Ram");

		System.out.println("isnide errorProneFunction");
		printNamesUnsafe(names, name -> System.out.println(name.toUpperCase()));

	}

	private static void printNamesUnsafe(List<String> names, Consumer<String> consumer) {

		System.out.println("isnide printNamesUnsafe");

		names.forEach(consumer);

	}
	
	static <T, E extends Exception> Consumer<T> consumerWrapper(Consumer<T> consumer, Class<E> clazz) {
	  
		System.out.println("Inside consumerWrapper");
		
	    return i -> {
	        try {
	            consumer.accept(i);
	        } catch (Exception ex) {
	            try {
	                E exCast = clazz.cast(ex);
	                System.err.println("Exception occured : " + exCast.getMessage() );
	            } catch (ClassCastException ccEx) {
	                throw ex;
	            }
	        }
	    };
	}

}
