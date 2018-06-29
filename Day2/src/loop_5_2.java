import java.util.Scanner;

public class loop_5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number : ");
		int i = sc.nextInt();
		int n = 1;
		int sum = 0;
		while (n <= i) {
			if (i % n == 0) {
				sum++;
			}
			n++;
		}
		System.out.println(sum);
	}

}
