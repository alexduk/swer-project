package edu.bu.domain;
public abstract class Person {
	
	String name;
	int age;
	Address address;
	

	public Person(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

}
