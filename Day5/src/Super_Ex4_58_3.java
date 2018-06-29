import java.util.Scanner;

public class Super_Ex4_58_3 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		int b;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input two number : ");
		a = sc.nextInt();
		b = sc.nextInt();		
		int max =max(a,b);
		System.out.println(max);
	}
	public static int max(int a, int b) 
	{
		/*int max;
		if(a>b)
		{
			max =a;
		}
		else
		{
			max = b;
		}
		return max;*/
		return a>b?a:b;
		
	}
}
