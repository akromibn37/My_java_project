import java.util.Scanner;

public class if_else_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mark;
		Scanner sc = new Scanner(System.in);
		mark = sc.nextInt();
		if (mark < 60) {
			System.out.println("F");
		} else if (mark < 70) {
			System.out.println("D");
		} else if (mark < 80) {
			System.out.println("C");
		} else if (mark < 90) {
			System.out.println("B");
		} else {
			System.out.println("A");
		}
	}

}
