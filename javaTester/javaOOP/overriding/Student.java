package javaOOP.overriding;

public class Student extends Person implements Iwork {
	@Override
	public void eat() {
		System.out.println("Eat 20k");
	}

	@Override
	public void sleep() {
		System.out.println("Sleep 8h");

	}

	@Override
	public void workingTime() {
		// TODO Auto-generated method stub

	}

}
