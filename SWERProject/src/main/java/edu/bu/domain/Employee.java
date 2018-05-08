package edu.bu.domain;
public class Employee extends Person {
	
	double salary;

	public Employee(String name, int age, Address address ,double salary) {
		super(name, age, address);
		this.salary = salary;
	}



	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
