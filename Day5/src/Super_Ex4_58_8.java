import java.util.Scanner;

public class Super_Ex4_58_8 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int x;
		Scanner sc =new Scanner(System.in);
		x=sc.nextInt();
		x=prime(x);
		System.out.println(x);
	}

	public static int prime(int a)
	{
		int count=0;
		for(int i = 1;i<=a;i++)
		{
			if(a%i==0)
			{
				count++;
			}
		}
		return count==2?0:1;
	}


}
