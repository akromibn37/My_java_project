import java.util.Scanner;

public class Super_Ex4_58_6 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x= sc.nextInt();
		System.out.println(largestPower2(x));
		
	}
	public static int largestPower2(int n)
	{
		int a=1;
		while(a*2<n)
		{
			a*=2;
		}
		if(a*2==n)return n;
		return a;
	}

}
