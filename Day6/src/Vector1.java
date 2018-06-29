
public class Vector1 {

	double x, y;

	public Vector1() {
		// TODO Auto-generated constructor stub
		x = 0;
		y = 0;
	}

	public Vector1(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector1 add(Vector1 v) {
		Vector1 result = new Vector1();// new = สร้าง
		result.x = this.x + v.x;
		result.y = this.y + v.y;
		return result;
	}
	public Vector1 sub(Vector1 v) {
		Vector1 result = new Vector1();// new = สร้าง
		result.x = this.x - v.x;
		result.y = this.y - v.y;
		return result;
	}
	public Vector1 mul(double m) {
		Vector1 result = new Vector1();// new = สร้าง
		result.x = this.x*m;
		result.y = this.y*m;
		return result;
	}
	public double dot(Vector1 v) {
		double result = this.x*v.x+this.y*v.y;
		return result;
	}
	public double size() {
		double result = Math.sqrt(x*x + y*y);
		return result;
	}
	public Vector1 unit() {
		double s = size();
		return new Vector1(x/s,y/s);
	}
	public String toString()
	{
		return "("+x + "," + y+")";
	}
	public static void main(String args[]){
		Vector1 a = new Vector1();
		a.x = 3;
		a.y = 4;
		Vector1 b = new Vector1(5,7);
		Vector1 c;
		c = a.add(b);
		System.out.println(c.x + " " + c.y);
		System.out.println(c);
		
		Vector1 d;
		d = a.sub(b);
		System.out.println(d);
		
		System.out.println(a.mul(5));
		System.out.println(a.dot(b));
		System.out.println(a.size());
		System.out.println(a.unit());
		
		
	}

}
