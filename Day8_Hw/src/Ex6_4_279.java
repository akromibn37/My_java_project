
public class Ex6_4_279 {
	
	int a,b;
	
	public Ex6_4_279()
	{
		
	}
	
	public Ex6_4_279(int a,int b)
	{
		this.a = a;
		this.b = b;
	}
	
	public int sum(Ex6_4_279 a)
	{
		return a.a+a.b;
	}
	public int sub(Ex6_4_279 a)
	{
		return a.a-a.b;
	}
	public int mul(Ex6_4_279 a)
	{
		return a.a*a.b;
	}
	public int div(Ex6_4_279 a)
	{
		return a.a/a.b;
	}
	public int mod(Ex6_4_279 a)
	{
		return a.a%a.b;
	}
}
