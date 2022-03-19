package javaBasic;

public class Topic_12_String {
	public static void main(String[] args) {

		// String className = "Automation Testing";
		// String classCity = "HCM";
		//
		// System.out.println(className.length());
		// System.out.println(className.charAt(2));
		// System.out.println(className.concat(classCity));
		//
		// System.out.println(className.substring(5, 9));

		// String result = "Viewing 48 of 132 results";
		// String arr[] = result.split(" ");
		// for (String string : arr) {
		// System.out.println(string);
		// }
		int a = 100;
		String b = String.valueOf(a);
		System.out.println(b.length());

		// Dynamic locator
		String dynamicButtonXpath = "//button[@id='%s']";

		System.out.println("Click to login button: " + dynamicButtonXpath.format(dynamicButtonXpath, "login"));

	}
}
