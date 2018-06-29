
public class Ex7_285_9_test_Point {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line a = new Line(2,7);
		System.out.println(a);
		Line b = new Line(-5,10);
		System.out.println(b);
		
		double x = a.getX(10);
		double y = a.getY(x);
		System.out.println("x = "+x +", y = "+y);
		
		Point p = new Point(1.5,11);
		boolean contains = a.contains(p);
		System.out.println(contains);
		
		boolean isparallel = a.isParallel(b);
		System.out.println(isparallel);
		
		boolean isPerpendicular = a.isPerpendicularTo(b);
		System.out.println(isPerpendicular);
		
		Point v = new Point();
		v = a.intersection(b);
		System.out.println(v);
		
		boolean c = a.equals(b);
		System.out.println(c);		
		
		
	}

}
