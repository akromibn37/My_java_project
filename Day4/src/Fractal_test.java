
public class Fractal_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fractal a = new Fractal();
		a.numerator =1;
		a.denominator=2;
		
		Fractal b = new Fractal();
		b.numerator = 1;
		b.denominator =2;
		Fractal c= a.add(b);
		Fractal d = a.sub(b);
		Fractal e = a.mul(b);
		Fractal f = a.div(b);
		System.out.println(c.numerator + " / "+c.denominator);
		System.out.println(d.numerator + " / "+d.denominator);
		System.out.println(e.numerator + " / "+e.denominator);
		System.out.println(f.numerator + " / "+f.denominator);
		System.out.println(Fractal.GCD(16, 240));
	}

}
