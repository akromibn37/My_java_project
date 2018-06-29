import java.util.Scanner;

public class Gravity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double R,m1,m2,F,G;
		System.out.println("Please input R(m)");
		R=sc.nextDouble();
		System.out.println("Please input mass of earth(kg)");
		m1=sc.nextDouble();
		System.out.println("Please input mass of the moon(kg)");
		m2 = sc.nextDouble();
		G=6.67e-11;
		F=(G*m1*m2)/(R*R);
		System.out.println("F = "+F +" kg");

	}

}
