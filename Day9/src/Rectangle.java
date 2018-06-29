
public class Rectangle implements Cloneable
{
	public Point corner;
	public double width,height;
	
	public Rectangle() 
	{
		
	}
	public Rectangle(Point corner,double width,double height)
	{
		this.corner = corner;
		this.width = width;
		this.height = height;
	}
	
	public String toString()
	{
		return "RECT : " + corner + " w :" +width+ " h : " +height;
	}
	
	public void grow(double dx,double dy)
	{
		this.width +=dx;
		this.height += dy;
	}
	
	public void move(double xx,double yy)
	{
		this.corner.x += xx;
		this.corner.y += yy;
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}

}
