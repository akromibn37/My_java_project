
public class Point {

	double x,y;
	public Point()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x,double y)
	{
		this.x = x;
		this.y =y;
	}
	
	public Point(Point p)
	{
		x = p.x;
		y = p.y;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	public void setX(double x)
	{
		this.x = x;
	}
	
	public void setY(double y)
	{
		this.y = y;
	}
	
	public double distanceTo(Point p)
	{
		return Math.sqrt(Math.pow(this.x -p.x, 2)+ Math.pow(this.y -p.y, 2));
	}
	
	public int getQuardrant()
	{
		if(this.x>=0 && this.y >= 0)
		{
			return 1;
		}
		else if(this.x<0 && this.y >= 0)
		{
			return 2;
		}
		else if(this.x<0 && this.y < 0)
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}
	
	public boolean equals(Point p)
	{
		if(this.x == p.x && this.y == p.y)
		{
			return true;
		}
//		else
//		{
			return false;
//		}
	}
	public String toString()
	{		
		return String.format("(%f,%f)", x,y);
	}
		
	
}
