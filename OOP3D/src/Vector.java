
public class Vector
{
	public double x,y;
	public Vector()
	{
		
	}
	public Vector(double xx,double yy)
	{
		x=xx;
		y=yy;
	}
	public Vector add(Vector v)
	{
		return new Vector(x+v.x , y+v.y);
	}
	public Vector sub(Vector v)
	{
		return new Vector(x-v.x , y-v.y);
	}
	public Vector mul(double v)
	{
		return new Vector(x*v , y*v);
	}
	public double dot(Vector v)
	{
		return x*v.x + y*v.y;
	}
	public double size()
	{
		return Math.sqrt(x*x+y*y);
	}
	public Vector unit()
	{
		double v = size();
		return new Vector(x/v , y/v);
	}
	
	public Vector rotate(double angle)
	{
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		
		double xx = x*cos + y*sin;
		double yy = -x*sin + y*cos;
		return new Vector(xx,yy);
	}
	
	public double getAngleWith_minusY()
	{
		Vector Y = new Vector(0,-1);
		double a = Math.asin(x*Y.y - Y.x *y);
		return a;
	}
	public String toString()
	{
		return x+" " +y;
	}
}
