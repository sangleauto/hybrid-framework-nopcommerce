package javaOOP.inheritance;

public class Animal {
	public Animal() {
		System.out.println("Parent's constructor");
	}

	public Animal(String name) {
		System.out.println("Parent's constructor - " + name);
	}

	public Animal(String name, int age) {
		System.out.println("Parent's constructor - " + name);
		System.out.println("Parent's constructor - " + age);
	}

	public void eat() {
		System.out.println("Eating something");
	}

}
