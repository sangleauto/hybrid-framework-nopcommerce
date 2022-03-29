package javaBasic;

public class Topic_15_Polymomorphism {
	public static void setName() {
		System.out.println("Sang");
	}

	public static void setName(String name) {
		System.out.println(name);
	}

	public static void main(String[] args) {
		setName();
		setName("Huy");
	}
}
