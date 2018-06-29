
public class J103_Exam_5_testPoint {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Point p = new Point();
		System.out.println(p.x + "," + p.y);
		
		Point p2 = new Point(3,4);
		System.out.println(p2.x + "," + p2.y);
		
		Point p3 = new Point(p2);
		System.out.println(p3.x + "," + p3.y);
		
		System.out.println(p3.getX());
		System.out.println(p3.getY());
		
		p3.setX(7);
		p3.setY(-8);
		System.out.println(p3.x + "," + p3.y);
		
		double distance = p2.distanceTo(p);
		System.out.println("Distance from p = "+distance);
		
		System.out.println("get Quadrant of p2 = " +p2.getQuardrant());
		System.out.println("get Quadrant of p3 = " +p3.getQuardrant());
		
		System.out.println(p3.equals(p2));
		
		System.out.println(p2);
		
	}

}
