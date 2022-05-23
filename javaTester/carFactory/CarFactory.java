package carFactory;

public class CarFactory {
	public static Car getCarType(CarType carType) {

		switch (carType) {
		case HONDA:
			return new Honda();
		case TOYOTA:
			return new Toyota();
		default:
			throw new IllegalArgumentException("This car type is not supported");
		}

	}
}
