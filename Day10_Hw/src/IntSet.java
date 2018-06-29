
public class IntSet {

	int []a;
	int i = 0;
	public IntSet()
	{
		
	}
	
	public IntSet(int n)
	{
		a = new int[n];
	}
	
	public void add(int x)
	{
		if(i<a.length)
		{
			a[i] = x;
			i++;
		}		
	}
	
	public boolean contains(int x)
	{
		boolean contains = false;
		for(int j=0;j<i;j++)
		{
			if(x == a[j])
			{
				contains = true;
			}
		}
		return contains;
	}
	
	public boolean isSubsetOf(IntSet s)
	{		
		int count =0;
		for(int j = 0;j<a.length;j++)
		{			
			for(int k = 0;k<s.a.length;k++)
			{
				if(a[j] == s.a[k])
				{
					count++;
				}
			}
		}
		if(count >=a.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public IntSet union(IntSet s)
	{
		IntSet ss = new IntSet (a.length+s.a.length);
		int l = 0;
		
		for(int j = 0;j<s.a.length;j++)
		{
			ss.a[j] = s.a[j];
		}
		l = s.a.length;
		for(int k = 0;k<a.length;k++)
		{
			int count = 0;
			for(int j = 0;j<ss.a.length;j++)
			{
				if(ss.a[j]==a[k])
				{
					count++;
				}
			}
			if(count ==0)
			{
				ss.a[l] = a[k];
				l++;
			}
		}
		return ss;
	}
	
	public IntSet intersection(IntSet s)
	{
		int max  = 0;
		if(s.a.length>a.length)
		{
			max = s.a.length;
		}
		else
		{
			max = a.length;
		}
		IntSet sa = new IntSet(max);		
		
		int l = 0;
		for(int i = 0;i<s.a.length;i++)
		{
			int count = 0;
			for(int j = 0;j<a.length;j++)
			{
				if(s.a[i] == a[j])
				{
					count++;
				}
			}
			if(count > 0)
			{
				sa.a[l] = s.a[i];
				l++;
			}
		}
		return sa;
	}
}
