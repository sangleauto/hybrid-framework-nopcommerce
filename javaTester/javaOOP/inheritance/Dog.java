package javaOOP.inheritance;

public class Dog extends Animal {
	private int age;

	public void sleep() {
		System.out.println("Sleep 2h");
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}

	public int getAge() {
		return age;
	}

}
