package com.test.methodreference;

import java.util.Arrays;
import java.util.List;

import com.test.lambda.entity.Person;

public class MethodReferenceWithCollection {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person(30, "Akhi", "Java"), new Person(32, "Ram", "Scala"));

		System.out.println("Lambda");
		persons.forEach(person -> System.out.println(person));

		System.out.println("Method Reference");
		persons.forEach(System.out::println);

	}

}
