package javaBasic;

public class Topic_01_Variable {
	static int studentNumber;
	static boolean statusValue;
	static final String BROWSER_NAME = "Chrome";
	
	String studentName = "Automation FC";
	
	public static void main(String[] args) {
		System.out.println(Topic_01_Variable.studentNumber);
		System.out.println(statusValue);
		
		Topic_01_Variable topic = new Topic_01_Variable();
		System.out.println(topic.studentName);
		
		Topic_01_Variable topic2 = new Topic_01_Variable();
		System.out.println(topic2.studentName);
		
		Topic_01_Variable topic3 = new Topic_01_Variable();
		System.out.println(topic3.studentName);
		
		System.out.println(Topic_01_Variable.BROWSER_NAME);
	}
	
	// Getter: getCurrentURL/ getTitle/ getText/ ...
	public String getStudentName() {
		return this.studentName;
	}
	
	// Setter: click/ sendkey/ clear/ select/ back/ forward/ refresh/ 	get/ ...
	public void setStudentName(String stdName) {
		this.studentName = stdName;
	}
	
	

}
