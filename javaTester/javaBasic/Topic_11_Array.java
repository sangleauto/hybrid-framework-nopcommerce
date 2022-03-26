package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;

public class Topic_11_Array {

	public static void main(String[] args) {

	}

	public void TC_01() {
		String studentName[] = { "sang", "huy", "linh" };
		ArrayList<String> stdName = new ArrayList<String>();
		for (String std : studentName) {
			stdName.add(std);
		}
		stdName.add("long");
		System.out.println(stdName);

		String stdNameString = Arrays.toString(studentName);
		System.out.println(stdNameString);
		// List<String> names = Arrays.asList("sang", "huy", "linh");
		// for (String name : names) {
		// System.out.println(name);
		// }

	}
}
