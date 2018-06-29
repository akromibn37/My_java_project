import java.util.Scanner;

public class if_else_1_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b,area,circum;
		System.out.print("Please input width and length : ");
		a = sc.nextInt();
		b= sc.nextInt();
		area = a*b;
		circum = a*2+b*2;
		System.out.println("Your area is "+area);
		System.out.println("Your circumference is "+circum);		
		
	}

}
