package com.test.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import com.test.lambda.entity.Person;

@FunctionalInterface
interface Condition {

	boolean test(Person person);

}

@FunctionalInterface
interface PersonPrinterFunctionalInterface {

	void printPerson(List<Person> persons);

}

@FunctionalInterface
interface PersonSortFunctionalInterface {

	List<Person> sortPerson(List<Person> persons);

}

public class UserDefinedLambdaExample {

	public static void main(String[] args) {

		Person[] persons = new Person[] { new Person(40, "Ak", "Java"), 
										  new Person(20, "Pk", "Test"),
										  new Person(30, "Dk", "Paython")
										};

		List<Person> persoLists = Arrays.asList(persons);

		 printList(persoLists);

		 sortPersons(persoLists);

		 printPerosnNameWithJavaProfile(persoLists);

	}

	private static void printPerosnNameWithJavaProfile(List<Person> persoLists) {

		/*
		 * Condition condition = (person)-> { return
		 * person.getProfile().equals("Java"); };
		 * 
		 * printConditionally(persoLists, condition);
		 */

		 printConditionally(persoLists, (person) -> person.getProfile().equals("Java"));

	}

	private static void printConditionally(List<Person> personlist, Condition condition) {

		for (Person p : personlist) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}

	}

	private static void sortPersons(List<Person> personlist) {

		PersonSortFunctionalInterface sortInterface = null;

		System.out.println("Unsorted List");
		for (Person person : personlist) {
			System.out.println(person);
		}

		// Java 7 way, creating anonymous class
		/*
		 * Collections.sort(persoLists, new Comparator<Person>() {
		 * 
		 * @Override public int compare(Person arg0, Person arg1) { return
		 * arg0.getAge().compareTo(arg1.getAge()); } });
		 */

		// Java 8 way, lambda expression
		Collections.sort(personlist, (p1, p2) -> {
			return p1.getAge().compareTo(p2.getAge());
		});

		System.out.println("Sorted List");
		for (Person person : personlist) {
			System.out.println(person);
		}

	}

	public static void printList(List<Person> persons) {

	/*	PersonPrinterFunctionalInterface printerlInterface = (personList1) -> {
			personList1.forEach(perosn -> System.out.println(perosn));
		};
		
		printerlInterface.printPerson(persons);
	*/
		
		persons.forEach( (person)-> { System.out.println(person); });

	}

}
