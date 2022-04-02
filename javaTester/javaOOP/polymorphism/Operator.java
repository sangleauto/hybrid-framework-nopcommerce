package javaOOP.polymorphism;

public class Operator {
	public void sum(int a, int b) {
		System.out.println(a + b);
	}

	public void sum(float a, float b) {
		System.out.println(a + b);
	}

	public void sum(long a, long b) {
		System.out.println(a + b + 100);
	}

	public static void main(String[] args) {
		Operator op = new Operator();
		op.sum(10, 10);
		op.sum(20, 20);
		op.sum(30l, 30);
	}
}
