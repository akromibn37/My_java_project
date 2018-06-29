import java.util.Scanner;

public class J103_Exam_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		double sum = 0, com;
		int i = 1;
		System.out.println("No.                              Total Sales(Baht)     Sales Commission(Baht)");
		for (;;) {

			System.out.print("Please input total sales of #" + i + " : ");
			n = sc.nextInt();
			if (n >= 0) {
				com = commission(n);
				sum += com;
				System.out.print( i + "                                " + n + "                   " + com);
			} else {
				break;
			}
			System.out.println();
			i++;
		}
		System.out.println("Commission total = " + sum);
	}

	public static double commission(int n) {
		double commission;
		if (n < 10000) {
			commission = 0;
		} else if (n < 25000) {
			commission = n * 0.07;
		} else {
			commission = n * 0.1;
		}
		return commission;
	}


}
