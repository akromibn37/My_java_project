import java.util.Arrays;
import java.util.Scanner;

public class Super_Ex4_58_10 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int [][]x=new int [5][7];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++)
			{
				x[i][j]= sc.nextInt();
			}
		}
		print(x);
		int []z = new int [5];
		for(int i=0;i<z.length;i++)
		{
			z[i] = calhour(x,i);
		}
		System.out.println(Arrays.toString(z));
		
	}
	public static void print(int [][]x)
	{
		System.out.println("     \t      Su M T W Th F Sa");
		for(int i=0;i<x.length;i++){
			System.out.print("Employee " +(i+1) + "\t");
			for(int j=0;j<x[0].length;j++)
			{
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int calhour(int [][]x,int y)
	{
		int sum=0;
		for(int i =0;i<x[0].length;i++)
		{
			sum+=x[y][i];
		}
		return sum;
	}

}
