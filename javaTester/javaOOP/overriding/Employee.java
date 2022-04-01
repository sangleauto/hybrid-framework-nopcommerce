package javaOOP.overriding;

public class Employee extends Person {
	@Override
	public void eat() {
		System.out.println("Eat 40k");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep 6h");

	}

}
