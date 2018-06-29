
public class Ex7_285_10_testRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rectangle a = new Rectangle(0,0,5,6);
		Point x = new Point(3,-3);
		
		double area = a.getArea();
		double Perimeter = a.getPerimeter();
		boolean contains = a.contains(x);
		System.out.println(area);
		System.out.println(Perimeter);
		System.out.println(contains);
	}

}
