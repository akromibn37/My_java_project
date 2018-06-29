
public class Point implements Cloneable
{
	public double x,y;
	public Point() 
	{
				
	}
	public Point(double x,double y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return String.format("(%f,%f)", x,y);
	}
	
	public boolean equals(Object o)
	{
		if(o instanceof Point)
		{
			Point pp = (Point)o;
			return pp.x == x && pp.y ==y;
//			return pp.x == x;
//			return Math.pow(pp.x-x, 2) + Math.pow(pp.y-y, 2)<10;
		}
		else
		{
			return false;
		}
	}
	
	public Point copyall()
	{
		return new Point(this.x,this.y);
	}	
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
	public static double getDistance(Point p1,Point p2)
	{
		return Math.sqrt(Math.pow(p1.x-p2.y, 2)+Math.pow(p1.y-p2.y, 2));
	}
	
	public double size_of_vector_to_this_point()
	{
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	
	public final void xxx()
	{
		System.out.println("sss");
	}

}
