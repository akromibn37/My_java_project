import java.util.Scanner;

public class number {
	double a,b,c;
	
	public number()
	{}
	
	public void filldata()
	{
		Scanner sc= new Scanner(System.in);
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
	}
	
	public double avg(number a)
	{
		double sum = 0;
		sum = a.a +a.b +a.c;
		return sum/3;
	}
}
