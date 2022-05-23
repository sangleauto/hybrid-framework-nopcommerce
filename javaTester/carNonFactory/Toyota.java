package carNonFactory;

public class Toyota implements Car {

	@Override
	public void viewCar() {
		System.out.println("View car Toyota");
	}

	@Override
	public void driveCar() {
		System.out.println("Drive car Toyota");
	}

}
