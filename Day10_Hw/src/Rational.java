
public class Rational {
	
	int numerator;
	int denominator;
	public static final int one = 1;
	public static final int zero = 0;

	public Rational()
	{
		numerator = zero;
		denominator = one;
	}
	
	public Rational(int n)
	{
		numerator = n;
		denominator = 1;
	}
	
	public Rational(int n,int d)
	{
		numerator = n;
		denominator = d;
	}
	
	public Rational add(Rational r)
	{
		Rational a = new Rational();
		a.numerator = (numerator*r.denominator)+(r.numerator*denominator);
		a.denominator = (denominator*r.denominator);
				
		return a;
	}
	
	public Rational sub(Rational r)
	{
		Rational a = new Rational();
		a.numerator = (numerator*r.denominator)-(r.numerator*denominator);
		a.denominator = (denominator*r.denominator);
				
		return a;
	}
	
	public Rational mul(Rational r)
	{
		Rational a = new Rational();
		a.numerator = (numerator*r.numerator);
		a.denominator = (denominator*r.denominator);
				
		return a;
	}
	
	public Rational div(Rational r)
	{
		Rational a = new Rational();
		a.numerator = (numerator*r.denominator);
		a.denominator = (denominator*r.numerator);
				
		return a;
	}
	
	public Rational inv()
	{
		Rational a = new Rational();
		a.numerator = denominator;
		a.denominator = numerator;
		
		return a;
	}
	
	public boolean equals(Rational r)
	{
		
		int gcd1 = GCD(denominator,numerator);
		int gcd2 = GCD(r.denominator,r.numerator);
		if(((r.denominator / gcd2) == (denominator/gcd1))&&((r.numerator / gcd2) == (numerator/gcd1)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String toString()
	{
		return String.format("(%d,%d)",numerator,denominator);
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
