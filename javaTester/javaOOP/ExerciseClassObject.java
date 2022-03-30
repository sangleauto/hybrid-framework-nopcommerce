package javaOOP;

public class ExerciseClassObject {

	private int studentID;
	private String studentName;
	private float firstScore;
	private float secondScore;

	protected ExerciseClassObject(int studentID, String studentName, float firstScore, float secondScore) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	protected double showStudentAvgScore() {
		return (firstScore + secondScore * 2) / 3;
	}

	protected void showStudentInfo() {
		System.out.println("Student name: " + studentName);
		System.out.println("Student id: " + studentID);
		System.out.println("Student average score: " + showStudentAvgScore());
	}

	public static void main(String[] args) {
		ExerciseClassObject student1 = new ExerciseClassObject(100, "Sang", 8, 9);
		student1.showStudentInfo();

		ExerciseClassObject student2 = new ExerciseClassObject(101, "Huy", 9, 10);
		student2.showStudentInfo();
	}

}
