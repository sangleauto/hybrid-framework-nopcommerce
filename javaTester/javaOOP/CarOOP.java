package javaOOP;

public class CarOOP {

	private String carName;
	private String carColor;
	private double carPrice;
	private float carSpeed;

	protected CarOOP(String carName, String carColor, double carPrice, float carSpeed) {
		this.carName = carName;
		this.carColor = carColor;
		this.carPrice = carPrice;
		this.carSpeed = carSpeed;
	}

	protected void showCarInfo() {
		System.out.println(carName);
		System.out.println(carColor);
		System.out.println(carPrice);
		System.out.println(carSpeed);
	}

	public static void main(String[] args) {
		CarOOP car = new CarOOP("Toyota", "Blue", 2000, 100);
		car.showCarInfo();
	}
}
