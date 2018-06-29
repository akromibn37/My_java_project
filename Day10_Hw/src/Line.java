
public class Line {

	double m,b;
	public Line()
	{
		
	}
	
	public Line(double m,double b)
	{
		this.m = m;
		this.b = b;
	}
	
	public Line(Line line)
	{
		this.m = line.m;
		this.b = line.b;
	}
	
	public double getX(double y)
	{
		return (y-b) / m;
	}
	
	public double getY(double x)
	{
		return m*x + b;
	}
	
	public boolean contains(Point p)
	{		
		if(p.y == p.x*m +b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isParallel(Line line)
	{
		if(this.m == line.m)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPerpendicularTo(Line line)
	{
		if(m*line.m == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Point intersection(Line line)
	{
		Point a = new Point();
		a.x = -(b-line.b)/(m-line.m);
		a.y = m*a.x + b;
		
		return a;
	}
	
	public boolean equals(Line line)
	{
		if(m == line.m && b == line.b)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public String toString()
	{		
		return String.format("(%f,%f)", m,b);
	}
}
