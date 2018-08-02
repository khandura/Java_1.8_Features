package com.test.methodreference;


interface BasicFunctionalInterface {
	
	void basicMethod();
}



public class BasicMethodReferenceExample {

	public static void classMethod(){
		System.out.println("Hellow World");
	}
	
	public static void main(String[] args) {
		
		BasicFunctionalInterface basicRef = ()-> classMethod();
		basicRef.basicMethod();
		
		basicRef = BasicMethodReferenceExample::classMethod;
		basicRef.basicMethod();
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				System.out.println("from run method");
			}
		};
		
		new Thread(r).start();
		
	 Runnable r1 = ()->{ System.out.println("from run method"); 
	 					};
	 new Thread(r1).start();
		
		
	}

}
