package javaOOP.knowledge;

public class Topic_03_Method {

	void showCarName() {
		System.out.println("Toyota");
	}

	static void showCarColor() {
		System.out.println("Red");
	}

	public static void main(String[] args) {
		Topic_03_Method car = new Topic_03_Method();
		car.showCarName();

		Topic_03_Method.showCarColor();
	}
}
