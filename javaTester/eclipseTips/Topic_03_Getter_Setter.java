package eclipseTips;

public class Topic_03_Getter_Setter {
	private String carName;
	private String carColor;

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public static void main(String[] args) {
		Topic_03_Getter_Setter topic = new Topic_03_Getter_Setter();
		topic.setCarName("toyota");
		System.out.println(topic.getCarName());
	}
}
