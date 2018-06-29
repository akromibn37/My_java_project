
public class Vector3f
{
	public double x,y,z;
	public Vector3f()
	{
		
	}
	public Vector3f(double xx,double yy,double zz)
	{
		x=xx;
		y=yy;
		z=zz;
	}
	public Vector3f add(Vector3f v)
	{
		return new Vector3f(x+v.x , y+v.y,z+v.z);
	}
	public Vector3f sub(Vector3f v)
	{
		return new Vector3f(x-v.x , y-v.y,z-v.z);
	}
	public Vector3f mul(double v)
	{
		return new Vector3f(x*v , y*v,z*v);
	}
	public double dot(Vector3f v)
	{
		return x*v.x + y*v.y+ z*v.z;
	}
	public double size()
	{
		return Math.sqrt(x*x+y*y+z*z);
	}
	public Vector3f unit()
	{
		double v = size();
		return new Vector3f(x/v , y/v,z/v);
	}
	
	public Vector3f rotate(double angle)
	{
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		
		double xx = x*cos + y*sin;
		double yy = -x*sin + y*cos;
		return new Vector3f(xx,yy,0);
	}
	
	public double getAngleWith_minusY()
	{
		Vector3f Y = new Vector3f(0,-1,0);
		double a = Math.asin(x*Y.y - Y.x *y);
		return a;
	}
	public String toString()
	{
		return "("+x+"," +y+"," + z+")";
	}
}
