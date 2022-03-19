package javaAccessModifier1st;

public class Computer {
	// Property
	private int ssdSize;

	String ramName;

	protected String cpuName;

	public String vgaBrand;

	// Method
	private void setSsdSize(int ssdSize) {
		this.ssdSize = ssdSize;
	}

	void setRamName(String ramName) {
		this.ramName = ramName;
	}

	protected void setCpuName(String cpuName) {
		this.vgaBrand = cpuName;
	}

	public void setVgaBrand(String vgaBrand) {
		this.vgaBrand = vgaBrand;
	}

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
