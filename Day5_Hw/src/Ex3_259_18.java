import java.util.Arrays;
import java.util.Scanner;

public class Ex3_259_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Data : ");
		int x =sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		int []t = new int[]{x,y,z};
		int max =max3(x,y,z);
		int min = min3(x,y,z);
		sort(t);
		System.out.println("min = " + min);
		System.out.println("max = " + max);
		System.out.println(Arrays.toString(t));
	}
	public static int max(int x,int y)
	{
		return x>y?x:y;
	}
	public static int max3(int x,int y,int z)
	{
		return max(max(x,y),z);
		
	}
	public static int min(int x,int y)
	{
		return x>y?y:x;
	}
	public static int min3(int x,int y,int z)
	{
		return min(min(x,y),z);
		
	}
	public static void sort(int x[])
	{
		int y;
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x.length-1;j++){
				if(x[j]>x[j+1])
				{
					y=x[j];
					x[j]=x[j+1];
					x[j+1]=y;
					
				}
			}
		}
	}


}
