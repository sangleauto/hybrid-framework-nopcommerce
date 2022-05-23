package carNonFactory;

import carFactory.Honda;
import carFactory.Toyota;

public class Client {

	public static void main(String[] args) {
		Honda honda = new Honda();
		honda.viewCar();
		honda.driveCar();

		Toyota toyota = new Toyota();
		toyota.viewCar();
		toyota.driveCar();
	}

}
