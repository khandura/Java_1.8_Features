package com.test.lambda;

import java.util.HashMap;
import java.util.Map;

public class BiFunctionBasicExample {

	public static void main(String[] args) {

		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		System.out.println(salaries);

		salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);

		System.out.println(salaries);

		salaries.forEach((k, v) -> System.out.println("Key : " + k + " : Value : " + v));

	}

}
