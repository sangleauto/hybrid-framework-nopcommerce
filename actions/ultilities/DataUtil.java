package ultilities;

import com.github.javafaker.Faker;

public class DataUtil {
	private Faker faker;

	public static DataUtil getData() {
		return new DataUtil();
	}

	public DataUtil() {
		faker = new Faker();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getUsername() {
		return faker.name().username();
	}

	public String getPassword() {
		return faker.internet().password();
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getCountry() {
		return faker.address().country();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getStateOrProVince() {
		return faker.address().state();
	}

	public String getZipCode() {
		return faker.address().zipCode();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}

}
