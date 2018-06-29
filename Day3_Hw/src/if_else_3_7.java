import java.util.Scanner;

public class if_else_3_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a1,b1,c1,a2,b2,c2,x,y;
		System.out.print("Please input a1: ");
		a1 = sc.nextDouble();
		System.out.print("Please input b1: ");
		b1 = sc.nextDouble();
		System.out.print("Please input c1: ");
		c1 = sc.nextDouble();
		System.out.print("Please input a2: ");
		a2 = sc.nextDouble();
		System.out.print("Please input b2: ");
		b2 = sc.nextDouble();
		System.out.print("Please input c2: ");
		c2 = sc.nextDouble();
		y = (((a2*c1)/a1)-c2)/(((b1*a2)/a1)-b2);
		x = (c1-(b1*y))/a1;
		System.out.println("x = "+x+", y = "+y);
	}

}
