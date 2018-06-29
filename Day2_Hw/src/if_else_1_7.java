import java.util.Scanner;

public class if_else_1_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double C,F;
		System.out.print("Please input celcius : ");
		C = sc.nextDouble();
		F=(9*C+160)/5;
		System.out.println("Your fahrenheit is "+ F );
	}

}
