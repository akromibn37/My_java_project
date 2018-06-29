
public class Rectangle {

	double x,y,w,h;
	public Rectangle()
	{
		
	}
	
	public Rectangle(double x,double y,double w,double h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;		
	}
	
	public double getArea()
	{
		return w*h;
	}
	
	public double getPerimeter()
	{
		return (w*2) +(h*2);
	}
	
	public boolean contains(Point p)
	{
		if((p.x<=x+w && p.x>=x) &&(p.y>=y-h && p.y< y))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
