package javaBasic;

import org.testng.annotations.Test;

public class Topic_12_Exercise_String {
	String courseName = "Automation Testing Advance";

	// @Test
	public void TC_01() {
		String[] coureNameArr = courseName.split("");
		int totalChar = 0;
		for (String eachChar : coureNameArr) {
			char newChar = eachChar.charAt(0);
			if (newChar >= 'A' && newChar <= 'Z') {
				System.out.println(newChar);
				totalChar += 1;
			}
		}
		System.out.println(totalChar);
	}

	// @Test
	public void TC_02() {
		String courseName = "Automation Testing 345 Tutorials Online 789";
		System.out.println(courseName);
		String letterArr[] = courseName.split("");
		int totalA = 0;
		for (String letter : letterArr) {
			if (letter.equalsIgnoreCase("a")) {
				totalA += 1;
			}
		}
		System.out.println(totalA);

		System.out.println(courseName.contains("Testing"));

		System.out.println(courseName.startsWith("Automation"));

		System.out.println(courseName.endsWith("Online"));

		System.out.println(courseName.indexOf("Tutorials"));

		courseName.replace("Offline", "Online");

		System.out.println(courseName);

		char charArr[] = courseName.toCharArray();
		int isDigit = 0;
		for (char c : charArr) {
			if (Character.isDigit(c)) {
				isDigit += 1;
			}
		}
		System.out.println("Tong ki tu la so: " + isDigit);
	}

	@Test
	public void TC_03() {
		String courseName = "Automation FC";

		char letterArr[] = courseName.toCharArray();

		for (int i = letterArr.length - 1; i >= 0; i--) {
			System.out.println(letterArr[i]);
		}

	}

}
