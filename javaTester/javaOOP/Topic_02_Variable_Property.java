package javaOOP;

public class Topic_02_Variable_Property {

	private String name;

	public static void main(String[] args) {
		Topic_02_Variable_Property student = new Topic_02_Variable_Property();
		System.out.println("Name: " + student.name);
		student.name = "sang";
		System.out.println("Name: " + student.name);

	}
}
