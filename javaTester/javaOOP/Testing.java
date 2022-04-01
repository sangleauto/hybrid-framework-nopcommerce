package javaOOP;

import javaOOP.overriding.Iwork;

public class Testing implements Iwork {
	public static void main(String[] args) {
		Topic_06_Getter_Setter topic = new Topic_06_Getter_Setter();

		topic.setPersonName("");
		// topic.setPersonName("Sang");
		// topic.setPersonName(null);

		System.out.println(topic.getPersonName());
	}

	@Override
	public void workingTime() {
		// TODO Auto-generated method stub

	}

}
