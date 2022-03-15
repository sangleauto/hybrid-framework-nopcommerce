package javaBasic;

public class Topic_05_Reference_Casting {
	
	public String studentName;
	
	public String GetStudentName() {
		return this.studentName;
	}
	
	public void SetStudentName(String stdName) {
		this.studentName = stdName;
	}
	
	public void showStudenName() {
		System.out.println(this.GetStudentName());
	}
	
	public static void main(String[] args) {
		Topic_05_Reference_Casting student1 = new Topic_05_Reference_Casting();
		Topic_05_Reference_Casting student2 = new Topic_05_Reference_Casting();
		
		student1.SetStudentName("Le Van A");
		student2.SetStudentName("Le Van B");

		student1.showStudenName();
		student2.showStudenName();
		
		//Ép kiểu
		student1 = student2;
		student1.showStudenName();
		student2.showStudenName();
		
		student2.SetStudentName("Le Van C");
		student1.showStudenName();
		student2.showStudenName();	
	}

}
