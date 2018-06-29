import java.util.Scanner;

public class resistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double R, l, A, p;
		System.out.println("A :");
		A = sc.nextDouble();
		System.out.println("l :");
		l=sc.nextDouble();
		p=1.59e-8;
		R=(p*l)/A;
		System.out.println("R = "+ R +" Ohms");
	}

}
