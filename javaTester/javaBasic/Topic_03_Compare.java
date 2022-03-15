package javaBasic;

public class Topic_03_Compare {
	int number = 10;
	public static void main(String[] args) {

		String name1 = "sang";
		String name2 = name1;
		
		// Show sang & sang
		System.out.println(name1);
		System.out.println(name2);

		name2 = "huy";
		
		// Show sang & huy
		System.out.println(name1);
		System.out.println(name2);
		
		Topic_03_Compare firstVariable = new Topic_03_Compare();
		Topic_03_Compare secondVariable = firstVariable;
		
		// Show 10 & 10
		System.out.println(firstVariable.number);
		System.out.println(secondVariable.number);
		
		secondVariable.number = 5;
		
		// Show 5 & 5
		System.out.println(firstVariable.number);
		System.out.println(secondVariable.number);
	}

}
