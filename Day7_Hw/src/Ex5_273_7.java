import java.util.Scanner;

public class Ex5_273_7 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Input 9 numbers : ");
		Scanner sc = new Scanner(System.in);
		int []d = new int[9];
		int sum = 0;
		for(int i=0;i<d.length;i++)
		{
			d[i] = sc.nextInt();
		}
		for(int i = 0;i<d.length;i++)
		{
			sum+=((i+1)*d[i]);
		}
		int d10 = sum%11;
		System.out.println(d10);
	}

}
