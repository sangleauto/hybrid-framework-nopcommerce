package javaOOP.inheritance;

import javaOOP.abstraction.Laptop;

public class Test {
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setAge(13);
		System.out.println(dog.getAge());

		Laptop lap = new Laptop();
		lap.showCPU();
		lap.showRam();
	}
}
