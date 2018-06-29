import java.util.Scanner;

public class simplehar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("L : ");
		double l,g,T;
		l=sc.nextDouble();
		System.out.println("T : ");
		T=sc.nextDouble();
		g= (4*Math.pow(Math.PI, 2)*l)/(T*T);
		System.out.println("g = "+ g);

	}

}
