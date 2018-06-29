import java.util.Scanner;

public class Ex4_268_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a : ");
		int a = sc.nextInt();
		float l = 0;
		float r = a;
		float x = (l + r) / 2;
		while ((a-(x*x)  > 1) || (a-(x*x)) < -1) {
			if (x * x > a) {
				r = (l + r) / 2;
			} else {
				l = (l + r) / 2;
			}
			x = (l + r) / 2;
			System.out.println(x);
		}
		System.out.print("a = " + a + " , Sqrt of a = ");
		System.out.printf("%.2f",x);
		/*
		 * float c = 3.5f; System.out.printf("%.0f",c);
		 */
	}

}
