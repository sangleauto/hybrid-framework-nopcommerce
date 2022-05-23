package carFactory;

public class Client {

	public static void main(String[] args) {
		Car hondaCar = CarFactory.getCarType(CarType.HONDA);
		hondaCar.viewCar();
		hondaCar.driveCar();

		Car toyotaCar = CarFactory.getCarType(CarType.TOYOTA);
		toyotaCar.viewCar();
		toyotaCar.driveCar();
	}

}
