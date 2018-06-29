import java.util.Scanner;

public class if_else_2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double weight;
		Scanner sc = new Scanner(System.in);
		weight = sc.nextDouble();
		if (weight > 0) {
			if (weight <= 1) {
				System.out.println("fee = 50 bath");
			} else if (weight <= 2) {
				System.out.println("fee = 60 bath");
			} else if (weight < 3) {
				System.out.println("fee = 70 bath");
			} else if (weight >= 3) {
				System.out.println("fee = 100 bath");
			}
		} else {
			System.out.println("Please run and fill again.");
		}
	}

}
