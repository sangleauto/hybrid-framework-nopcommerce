package javaBasic;

public class Topic_11_Exercise_Array {

	// @Test
	public void TC_01() {
		int arr[] = { 2, 7, 6, 8, 9 };
		int maxNumber = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= maxNumber) {
				maxNumber = arr[i];
			}
		}
		System.out.println("Max number: " + maxNumber);
	}

	// @Test
	public void TC_02() {
		int arr[] = { 2, 7, 9, 11, 18 };
		System.out.println("Tong phan tu dau va cuoi: " + (arr[0] + arr[arr.length - 1]));
	}

	// @Test
	public void TC_03() {
		int arr[] = { 2, 7, 9, 11, 18, 20 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				System.out.println(arr[i]);
			}
		}
	}

	// @Test
	public void TC_04() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0 && arr[i] > 0) {
				total += arr[i];
			}
		}
		System.out.println("Tong cac so le lon hon 0: " + total);
	}

	// @Test
	public void TC_05() {
		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0 && arr[i] <= 10) {
				System.out.println(arr[i]);
			}
		}
	}

	// @Test
	public void TC_06() {
		int arr[] = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };
		float total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		float avg = total / arr.length;
		System.out.println("Tong la: " + total);
		System.out.println("Trung binh cong la: " + avg);
	}

	// @Test

	String id;
	String name;
	int age;
	float score;

	public Topic_11_Exercise_Array(String id, String name, int age, float score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void display() {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Score: " + score);
	}

	public static void main(String[] args) {
		Topic_11_Exercise_Array student[] = new Topic_11_Exercise_Array[3];
		student[0] = new Topic_11_Exercise_Array("a", "sang", 20, 8.5f);
		student[1] = new Topic_11_Exercise_Array("b", "huy", 21, 9.5f);
		student[2] = new Topic_11_Exercise_Array("c", "linh", 22, 7.5f);

		for (int i = 0; i < student.length; i++) {
			student[i].display();
		}
	}

}
