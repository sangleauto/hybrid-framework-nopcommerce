package javaAccessModifier2nd;

import javaAccessModifier1st.Computer;

public class WorkStation {
	public static void main(String[] args) {
		Computer computer = new Computer();
		// Property
		computer.vgaBrand = "AMD";
		System.out.println(computer.vgaBrand);

		// Method
		computer.setVgaBrand("Nvidia");
		System.out.println(computer.vgaBrand);
	}
}
