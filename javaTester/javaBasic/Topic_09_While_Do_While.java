package javaBasic;

public class Topic_09_While_Do_While {

	public static void main(String[] args) {
		int i;

		for (i = 0; i < 5; i++) {
			System.out.println("For: i = " + i);
		}

		while (i < 5) {
			System.out.println("While: i = " + i);
			i++;
		}

		do {
			System.out.println("Do-While: i = " + i);
			i++;
		} while (i < 5);

	}

}
