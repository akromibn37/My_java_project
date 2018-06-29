import java.util.Scanner;

public class if_else_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		double feet,cm,lha;
		System.out.print("Please input number : ");
		n = sc.nextInt();
		feet = (double)n/12;
		cm = (double)n*2.54;
		lha = (double)n/36;
		System.out.println(n+"' is equal to " +feet +" feet");
		System.out.println(n+"' is equal to " +cm +" cm");
		System.out.println(n+"' is equal to " +lha +" lha");
	}

}
