import java.util.Arrays;
import java.util.Random;

public class Ex4_268_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []x= new int [100];
		filldata(x);
		System.out.println(Arrays.toString(x));
		int max = max(x);
		int min = min(x);
		double avg = avg(x);
		System.out.println("max = "+ max);
		System.out.println("min = "+ min);
		System.out.println("avg = "+ avg);
		
	}
	public static void filldata(int []x)	
	{
		Random rand = new Random();
		for(int i=0;i<x.length;i++)
		{
			x[i] = rand.nextInt(100);
		}
	}
	public static int max(int []x)
	{
		int max =Integer.MIN_VALUE;
		for(int i=0;i<x.length;i++)
		{
			if(x[i]>max)
			{
				max = x[i];
			}			
		}
		return max;
	}
	public static int min(int []x)
	{
		int min =Integer.MAX_VALUE;
		for(int i=0;i<x.length;i++)
		{
			if(x[i]<min)
			{
				min = x[i];
			}			
		}
		return min;
	}
	public static double avg(int []x)
	{
		double sum = 0;
		for(int i=0;i<x.length;i++)
		{
			sum+= x[i];
		}
		return sum/x.length;
	}

}
