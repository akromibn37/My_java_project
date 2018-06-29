import java.util.Scanner;

public class loop_3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, n;
		double sum;
		System.out.print("PLease input n : ");
		n = sc.nextInt();
		i = 1;
		sum = 0;
		while (i <= n) {
			sum = sum + 1.0/i;
			i++;
		}
		System.out.println("Sum 1/1 to 1/" + n + " = " + sum);
	}

}
