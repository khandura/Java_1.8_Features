package com.test.lambda;

import com.test.functionalinterface.MyProcessor;

public class ThisReferenceInsideLambda {

	public static void main(String[] args) {
		
		String name = "ABC";
		MyProcessor<String> processor = (string)->System.out.println(string);
		
		ThisReferenceInsideLambda thisInsideLambda = new ThisReferenceInsideLambda();
		
		thisInsideLambda.doProcess(name, processor);
		
		processor = (string)->{ 
			System.out.println(string);
		//	System.out.println(this);		//can't access this keyword inside the lambda block, as lambda doesn't override this.
		};
		
				
	/*	thisInsideLambda.doProcess(name, new MyProcessor<String>(){
			
			@Override
			public void process(String t) {
				System.out.println(t);
				System.out.println(this);
			};
			
			@Override
			public String toString() {
				return "Annoymous class";
			}
		});
	*/
	}

	
	public void doProcess(String name, MyProcessor<String> processor) {
		System.out.println("Name : "+name);
		processor.process("XYZ");
		System.out.println(this);
	}


	@Override
	public String toString() {
		return "ThisReferenceInsideLambda [toString()=" + super.toString() + "]";
	}
	
	
	
}
