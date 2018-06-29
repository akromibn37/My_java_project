import java.util.Arrays;
import java.util.Random;

public class Ex4_268_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double []x= new double [50];
		filldata(x);
		System.out.println(Arrays.toString(x));
		sort(x);
		System.out.println(Arrays.toString(x));
	}
	public static void filldata(double []x)	
	{
		Random rand = new Random();
		for(int i=0;i<x.length;i++)
		{
			x[i] = rand.nextDouble()*10;
		}
	}
	public static void sort(double []x)
	{
		double y;
		for(int i=0;i<x.length;i=i+2)
		{
			y=x[i];
			x[i]=x[i+1];
			x[i+1]=y;
		}
	}

}
