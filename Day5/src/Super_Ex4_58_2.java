import java.util.Scanner;

public class Super_Ex4_58_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input two number : ");
		a = sc.nextInt();
		b = sc.nextInt();
		int []z =new int [1];
		sum(a,b,z);
		System.out.println(z[0]);
	}
	public static void sum(int a, int b,int[]c) 
	{
		c[0] = a+b;
		
	}

}
