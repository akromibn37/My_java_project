import java.util.Scanner;

public class Student_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] s = new Student[3];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < s.length; i++) {
			System.out.println("Please input naame,surname of student " + i + " : ");
			s[i] = new Student();
			s[i].name = sc.nextLine();
			s[i].surname = sc.nextLine();
			s[i].score = sc.nextInt();
			sc.nextLine();
		}
		Student max = s[0];
		for (int i = 0; i < s.length; i++) {
			if (max.score < s[i].score) {
				max = s[i];
			}
		}
		System.out.println(max.name + " " + max.score );
	}

}
