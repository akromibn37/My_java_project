import java.util.Random;

public class ExMe_276_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =random(10);
		int b = random(5,10);
		double c = random(5,10);
		System.out.println(a + " , "+ b + " , " + c);
	}
	public static int random(int b)
	{
		Random rand = new Random();
		int x =rand.nextInt(b);
		return x;
	}
	public static int random(int a,int b)
	{		
		int x = a + (int)(Math.random() * ((b - a) + 1));
		return x;
	}
	public static double random(double a,double b)
	{
		return a + (Math.random() * (b - a));
	}

}
