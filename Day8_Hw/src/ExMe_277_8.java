
public class ExMe_277_8 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}
	public static boolean isSquare(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		double a,b,c,d;
		a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2, 2));
		b = Math.sqrt(Math.pow((x1-x4),2)+Math.pow(y1-y4, 2));
		c = Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3, 2));
		d = Math.sqrt(Math.pow((x3-x2),2)+Math.pow(y3-y2, 2));
		if((a==b)==(d==c))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isRectangle(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		double a,b,c,d;
		a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2, 2));
		b = Math.sqrt(Math.pow((x1-x4),2)+Math.pow(y1-y4, 2));
		c = Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3, 2));
		d = Math.sqrt(Math.pow((x3-x2),2)+Math.pow(y3-y2, 2));
		if(a==c && b==d)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isRhombus(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		double a,b,c,d;
		a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2, 2));
		b = Math.sqrt(Math.pow((x1-x4),2)+Math.pow(y1-y4, 2));
		c = Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3, 2));
		d = Math.sqrt(Math.pow((x3-x2),2)+Math.pow(y3-y2, 2));
		if(((a==b)==(c==d))&& !(isSquare(x1,y1,x2,y2,x3,y3,x4,y4)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isParallelogram(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		double a,b,c,d;
		a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2, 2));
		b = Math.sqrt(Math.pow((x1-x4),2)+Math.pow(y1-y4, 2));
		c = Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3, 2));
		d = Math.sqrt(Math.pow((x3-x2),2)+Math.pow(y3-y2, 2));
		if((a==c && b==d)&& !(isRectangle(x1,y1,x2,y2,x3,y3,x4,y4)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static boolean isTrapezoid(int x1,int y1,int x2,int y2,int x3,int y3,int x4,int y4)
	{
		double a,b,c,d;
		a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow(y1-y2, 2));
		b = Math.sqrt(Math.pow((x1-x4),2)+Math.pow(y1-y4, 2));
		c = Math.sqrt(Math.pow((x4-x3),2)+Math.pow(y4-y3, 2));
		d = Math.sqrt(Math.pow((x3-x2),2)+Math.pow(y3-y2, 2));
		if(((a==b)||(c==d))&&!((a==b)==(c==d)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
