
public class Fractal {

	public int numerator; // àÈÉ
	public int denominator; // ÊèÇ¹

	public Fractal add(Fractal f) 
	{
		Fractal result = new Fractal();
		result.denominator = denominator * f.denominator;
		result.numerator = numerator * f.denominator + f.numerator * denominator;
		int gcd = GCD(result.denominator,result.numerator);
		result.denominator /= gcd;
		result.numerator /=gcd;
		
		return result;
	}
	public Fractal sub(Fractal f)
	{
		Fractal result = new Fractal();
		result.denominator = denominator *f.denominator;
		result.numerator = numerator*f.denominator -f.numerator*denominator;
		int gcd = GCD(result.denominator,result.numerator);
		result.denominator /= gcd;
		result.numerator /=gcd;
		return result;
	}
	public Fractal mul(Fractal f)
	{
		Fractal result = new Fractal();
		result.denominator = denominator *f.denominator;
		result.numerator = numerator*f.numerator;
		int gcd = GCD(result.denominator,result.numerator);
		result.denominator /= gcd;
		result.numerator /=gcd;
		return result;
	}
	public Fractal div(Fractal f)
	{
		Fractal result = new Fractal();
		result.denominator = denominator *f.numerator;
		result.numerator = numerator*f.denominator;
		int gcd = GCD(result.denominator,result.numerator);
		result.denominator /= gcd;
		result.numerator /=gcd;
		return result;
	}
	

	public static int GCD(int a, int b) 
	{
		if (a > b) 
		{

		} 
		else 
		{
			int t = a;
			a = b;
			b = t;
		}
		while (b > 0) {
			a = a % b;
			int t = a;
			a = b;
			b = t;
		}
		return a;
	}

}
