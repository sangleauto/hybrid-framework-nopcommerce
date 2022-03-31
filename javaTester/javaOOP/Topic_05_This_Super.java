package javaOOP;

public class Topic_05_This_Super extends BaseOOP {
	private int firstNumber = 5;
	private int secondNumber = 10;

	public Topic_05_This_Super() {

	}

	public void showNumber() {
		System.out.println("Show 1st number: " + super.firstNumber);
		System.out.println("Show 2nd number: " + super.secondNumber);
	}

	public String getName() {
		return "Sang";
	}

	public void showName() {
		System.out.println(super.getName());
	}

	public static void main(String[] args) {
		Topic_05_This_Super topic = new Topic_05_This_Super();
		topic.showNumber();
		topic.showName();

	}

}
