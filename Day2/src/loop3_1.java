import java.util.Scanner;

public class loop3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i, n, sum;
		System.out.print("PLease input n : ");
		n = sc.nextInt();
		i = 1;
		sum = 0;
		while (i <= n) {
			sum = sum + i;
			i++;
		}
		System.out.println("Sum 1 to " + n + " = " + sum);

	}

}
