package com.test.lambda;

import java.util.function.BiConsumer;

public class ExceptionHandlingUsingLambda {

	public static void main(String[] args) {
		//badApproch();
		//goodApproach();
		bestApproach();
	}

	private static void bestApproach() {

		Integer a = 10, b = 0;
		performActionAndPrintResult(a, b, lambdaExceptionWrapper((num1, num2) -> System.out.println(num1 / num2)));

	}

	private static BiConsumer<Integer, Integer> lambdaExceptionWrapper(BiConsumer<Integer, Integer> consumer) {

		System.out.println("inside lambdaExceptionWrapper()");
		
		return (num1, num2) -> {
			try {
				consumer.accept(num1, num2);
			} catch (ArithmeticException ae) {
				System.err.println("Best Approach : Use wrappers to handle exceptio : ArithmeticException has occured. "
						+ ae.getMessage());
				ae.printStackTrace();
			}
		};
	}

	private static void goodApproach() {

		int a = 10, b = 0;

		try {
			performActionAndPrintResult(a, b, (num1, num2) -> System.out.println("Devision : " + (num1 / num2)));
		} catch (ArithmeticException e) {
			System.err.println("Good Approach : ArithmeticException has occured. " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static void badApproch() {

		int a = 10, b = 0;

		performActionAndPrintResult(a, b, (num1, num2) -> {
			try {
				System.out.println("Remainder : " + (num1 / num2));
			} catch (ArithmeticException e) {
				System.err.println("Bad Approach : ArithmeticException has occured : " + e.getMessage());
				e.printStackTrace();
			}
		});
	}

	private static void performActionAndPrintResult(int a, int b, BiConsumer<Integer, Integer> consumer) {
		System.out.println("inside performAction()");
		consumer.accept(a, b);
	}

}
