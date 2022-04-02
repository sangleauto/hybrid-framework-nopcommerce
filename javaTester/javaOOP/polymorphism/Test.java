package javaOOP.polymorphism;

public class Test {
	public static void main(String[] args) {
		Animal animal = new Animal();
		animal.eat();

		animal = new Pig();
		animal.eat();
	}
}
