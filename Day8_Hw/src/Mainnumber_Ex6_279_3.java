import java.util.Scanner;

public class Mainnumber_Ex6_279_3 extends number{
	
	public Mainnumber_Ex6_279_3()
	{		
		
	}
	public Mainnumber_Ex6_279_3(double a,double b,double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a,b,c;
//		Scanner sc = new Scanner(System.in);		
//		a = sc.nextDouble();
//		b = sc.nextDouble();
//		c = sc.nextDouble();		
		
		Mainnumber_Ex6_279_3 mc = new Mainnumber_Ex6_279_3();
		mc.filldata();
		double avg = mc.avg(mc);
		
		System.out.println(avg);
	}

}
