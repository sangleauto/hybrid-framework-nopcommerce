package javaOOP;

public final class Topic_04_Non_Access_Modifier {

	// Static: Variable/ Method
	static String browserName = "Chrome";

	// Non-static
	String serverName = "Testing";

	// Final
	final String colorCar = "Black";

	public static void main(String[] args) {
		System.out.println(browserName);

		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);

		topic.ClickToElement("button");

		Topic_04_Non_Access_Modifier.SendKeyToElement("input");
	}

	// Non-static
	public void ClickToElement(String elementName) {
		System.out.println();
	}

	// Static
	public static void SendKeyToElement(String elementName) {
		System.out.println();
	}

	// Final
	public final void setCarName() {

	}
}
