package carFactory;

public class Honda implements Car {

	@Override
	public void viewCar() {
		System.out.println("View car Honda");
	}

	@Override
	public void driveCar() {
		System.out.println("Drive car Honda");
	}

}
