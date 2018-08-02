package com.test.lambda;

/**
 * This is functional interface, will required for lambda to work.
 * 
 * @author hp laptop
 *
 */
interface BasicLambda {
	void basicMethod();
}


public class BasicLambdaExample {

	public static void callMethodUsingLambda() {

		/**
		 * below piece of code will create an object of anonymous class, which
		 * is of Type BasicLambda(functional interface), and provides the method
		 * definition to the only method declared inside functional interface
		 */
		BasicLambda lambda = () -> {
			System.out.println("Hello Lambda");
		};

		lambda.basicMethod();
	}

	public static void main(String[] args) {

		callMethodUsingLambda();

	}

}
