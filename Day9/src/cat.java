
public class cat extends Mammal{
	
	double x,y;
	static double z;
	final double THIS_IS_CONST ;
	static final double THSI_IS_CONT_STATIC = 10;
	
	public cat()
	{
		THIS_IS_CONST =12;		
	}
	
	public String toString()
	{
		return "x = " + x +" y = " + y + " z = " +z ;
	}
	
	public void say()
	{
		
		System.out.println(x + " Meaw");
	}
	public static void xxx()
	{
		System.out.println();
	}
}
