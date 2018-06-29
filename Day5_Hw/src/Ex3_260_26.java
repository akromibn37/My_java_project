import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex3_260_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		int n,lowerindex,upperindex;
		System.out.print("input array length : ");
		n= sc.nextInt();
		int []ar = new int[n];
		filldata(ar);
		System.out.print("Input lowerindex and upperindex : ");
		lowerindex = sc.nextInt();
		upperindex = sc.nextInt();
		int sum;
		if(upperindex>lowerindex)
		{
			sum = sumdata(ar,lowerindex,upperindex);
			System.out.println(sum);
		}
		else
		{
			System.out.println("Error");
		}
		System.out.println(Arrays.toString(ar));
		
	}	
	public static void filldata(int []x)
	{
		Random rand = new Random();
		for(int i=0;i<x.length;i++)
		{
			x[i] = rand.nextInt(1000);
		}
	}
	public static int sumdata(int []x,int a,int b)
	{
		int sum = 0;
		for(int i = a;i<=b;i++)
		{
			sum += x[i];
		}
		return sum;
	}

}
