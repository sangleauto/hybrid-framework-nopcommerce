package javaAccessModifier2nd;

import javaAccessModifier1st.Computer;

public class PC extends Computer {
	public void showCpuName() {
		System.out.println(cpuName);
		setCpuName("AMDd");
		System.out.println(cpuName);
	}
}
