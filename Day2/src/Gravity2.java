import java.util.Scanner;

public class Gravity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double g,m1,m2,R,F;
		System.out.println("Please input R(m)");
		R=sc.nextDouble();
		System.out.println("Please input mass of earth(kg)");
		m1=sc.nextDouble();
		System.out.println("Please input mass of the moon(kg)");
		m2 = sc.nextDouble();	
		System.out.println("Please input Force");
		F = sc.nextDouble();
		g=(F*R*R)/(m1*m2);
		System.out.println("G = "+g );

	}

}
