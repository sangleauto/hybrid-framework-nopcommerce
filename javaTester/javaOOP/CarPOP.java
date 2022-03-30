package javaOOP;

public class CarPOP {
	static String carName;
	static String carColor;
	static double carPrice;
	static float carSpeed;

	public static void main(String[] args) {
		carName = "BMW";
		carColor = "Red";
		carPrice = 1000;
		carSpeed = 200f;

		System.out.println(carName);
		System.out.println(carColor);
		System.out.println(carPrice);
		System.out.println(carSpeed);

		carName = "Toyota";
		carColor = "Blue";
		carPrice = 2000;
		carSpeed = 300f;

		System.out.println(carName);
		System.out.println(carColor);
		System.out.println(carPrice);
		System.out.println(carSpeed);
	}
}
