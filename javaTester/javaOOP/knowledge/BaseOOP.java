package javaOOP.knowledge;

public class BaseOOP {
	protected int firstNumber = 50;
	protected int secondNumber = 100;

	public BaseOOP() {
		System.out.println("Constructor cua class Cha");
		System.out.println("Constructor cua class Cha");
	}

	public BaseOOP(int num) {
		System.out.println("Return number: " + num);
	}

	protected String getName() {
		return "Huy";
	}
}
