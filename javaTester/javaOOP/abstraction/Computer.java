package javaOOP.abstraction;

public abstract class Computer {
	public int numTest = 10;

	public abstract void showRam();

	public void showCPU() {
		System.out.println("Intel i7");
	}

}
