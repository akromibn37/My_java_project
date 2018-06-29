import java.util.Scanner;

public class if_else_1_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int xbar, a, b, c,sum;
		System.out.print("Please input a,b,c : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		xbar = (a+b+c)/3;
		sum = a+b+c;
		System.out.println("Your average of this data is "+xbar+" and you total value is "+sum);
		
	}

}
