package javaAccessModifier1st;

public class Laptop {
	public static void main(String[] args) {
		Computer computer = new Computer();
		// Property
		computer.cpuName = "Intel";
		System.out.println(computer.cpuName);

		// Method
		computer.setCpuName("AMD");
		System.out.println(computer.cpuName);
	}
}
