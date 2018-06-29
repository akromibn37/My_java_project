import java.util.Scanner;

public class Super_Ex4_58_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		int r;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input two number : ");
		a = sc.nextInt();
		b = sc.nextInt();
		r = sum(a, b);
		System.out.println(r);

	}

	public static int sum(int a, int b) {
		int sum;
		sum = a + b;
		return sum;
	}

}
