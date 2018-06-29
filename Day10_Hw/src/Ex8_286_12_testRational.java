
public class Ex8_286_12_testRational {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational a = new Rational();
		Rational b = new Rational(3);
		Rational c = new Rational(6,2);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		b = b.add(c);
		System.out.println(b);
		c= a.sub(b);
		System.out.println(c);
		a = c.mul(b);
		System.out.println(a);
		b = a.div(c);
		System.out.println(b);
		
		b = b.inv();
		System.out.println(b);
		
		Rational d =new Rational(12,18);
		Rational e = new Rational(16,24);
		boolean r = d.equals(e);
		System.out.println(r);
		
	}

}
