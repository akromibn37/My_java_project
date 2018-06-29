import java.util.Scanner;

public class Super_Ex4_58_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		int c;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input three number : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		int max3 = max3(a, b,c);
		System.out.println(max3);
	}
	public static int max(int a,int b)
	{
		return a>b?a:b;
	}
	public static int max3(int a,int b,int c)
	{
		int m =max(a,b);
		m = max(m,c);
		return m;
		//return max(max(a,b),c);
	}
	

	/*public static int max(int a, int b,int c) {
		int max = Integer.MIN_VALUE;
		if(a>max)
		{
			max =a;
		}
		if(b>max)
		{
			max=b;
		}
		if(c>max)
		{
			max = c;
		}
		return max;
		
	}*/

}
