
public class RectangleTest 
{

	public static void main(String[] args) 
	{
		Point p = new Point(20,30);
		Rectangle r = new Rectangle(p,100,200);
		System.out.println(r);
		r.width +=30;
		r.height +=30;
		System.out.println(r);
		r.grow(20, 20);
		System.out.println(r);
		
		r.move(-10, -10);
		System.out.println(r);
		
		Point a = new Point(3,4);
		Point b = new Point(3,4);
		if(a.equals(b))
		{
			System.out.println("OK");
		}
		else
		{
			System.out.println("No");
		}
		
		Point c = a;
		System.out.println("a==c : " +(a==c));
		System.out.println(a.equals(b));
		
		try {
			Rectangle rr = r;
			Rectangle copy = (Rectangle)r.clone();
			System.out.println(r);
			System.out.println(copy);
			System.out.println("rr = " +r);
			r.corner.x = 55555;
			r.width = 105555;
			System.out.println(r);
			System.out.println(copy);
			System.out.println("rr = " + r);
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
