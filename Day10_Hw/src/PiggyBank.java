
public class PiggyBank {

	int one,two,five,ten;
	public PiggyBank()
	{
		one = 0;
		two = 0;
		five = 0;
		ten = 0;
	}
	
	public void add1(int c)
	{
		one = one +c;
	}
	
	public void add2(int c)
	{
		two = two+c;
	}
	
	public void add5(int c)
	{
		five = five+c;
	}
	
	public void add10(int c)
	{
		ten = ten+c;
	}
	
	public void clear()
	{
		one = 0;
		two =0;
		five = 0;
		ten = 0;
	}
	
	public int getTotal()
	{
		return one*1 + two*2 +five*5 +ten*10;
	}
	
	public String toString()
	{
		//return String.format("(%d,%d,%d,%d)", one,two,five,ten);
		return String.format(" (1 = %d,2 = %d,5 = %d,10 = %d)", one,two,five,ten);
	}
}
