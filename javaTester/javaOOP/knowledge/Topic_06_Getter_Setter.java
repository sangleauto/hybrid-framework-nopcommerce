package javaOOP.knowledge;

public class Topic_06_Getter_Setter {
	private String personName;
	private int personAge;
	private int personAccountBalance;

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		if (personAge < 18 || personAge > 120) {
			throw new IllegalArgumentException("Tuoi nhap vao khong hop le");

		} else {
			this.personAge = personAge;
		}

	}

	public int getPersonAccountBalance() {
		return personAccountBalance;
	}

	public void setPersonAccountBalance(int personAccountBalance) {
		this.personAccountBalance = personAccountBalance;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Ten ban nhap vao khong hop le");
		} else
			this.personName = personName;
	}

	public void showPersonInfo() {
		System.out.println("Ten: " + getPersonName());
		System.out.println("Tuoi: " + getPersonAge());
		System.out.println("So du: " + getPersonAccountBalance());
	}

	public static void main(String[] args) {
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();
		topic.setPersonName("Huy");
		topic.setPersonAge(20);
		topic.setPersonAccountBalance(200000);
		topic.showPersonInfo();
	}
}
