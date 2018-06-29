import java.util.Scanner;

public class Super_Ex4_58_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x;
		Scanner sc =new Scanner(System.in);
		x = sc.nextDouble();
		x = absolute(x);
		System.out.println(x);
		
	}
	public static double absolute(double x)
	{
		return Math.abs(x);
	}

}
