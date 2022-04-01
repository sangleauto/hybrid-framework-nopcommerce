package javaOOP.knowledge;

public class Topic_01_Class_Object_Student {

	private int studentID;
	private String studentName;
	private Float firstScore;
	private Float secondScore;

	protected Topic_01_Class_Object_Student(int studentID, String studentName, float firstScore, float secondScore) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	protected Float showStudentAvgScore() {
		return (this.firstScore + this.secondScore * 2) / 3;
	}

	protected void showStudentInfo() {
		System.out.println("Student name: " + studentName);
		System.out.println("Student id: " + studentID);
		System.out.println("Student average score: " + showStudentAvgScore());
	}

	public static void main(String[] args) {
		Topic_01_Class_Object_Student student1 = new Topic_01_Class_Object_Student(100, "Sang", 8f, 9f);
		student1.showStudentInfo();

		Topic_01_Class_Object_Student student2 = new Topic_01_Class_Object_Student(101, "Huy", 9f, 10f);
		student2.showStudentInfo();
	}

}
