import java.util.Arrays;
import java.util.Random;

public class Ex7_280_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []d = new int[]{1,2,2,2,2,2,2,2,4,4,3,3};
		int []a = new int[]{1,2,3,4,5,6,7,8};
		int []b = new int[]{1,2,3,4,5,6,7,8};
		double []z = new double[]{1,2,3,6,5};
		double []q = new double[]{2,-1,3,-5,3};
		int []v = new int[]{1,2,3,4,5,6,7,8};
		int []t = new int[]{7,6,5,4,3,2,1};
		String []s = new String[]{"hi","kkk","ee"};
		int mode = mode(d);
		int count = count(d,3);
		boolean major = majority(d);
		remove(a,2);
		insert(a,2,15);
		int []x = shuffled(b);
		System.out.println("b notshuffle = "+Arrays.toString(b));
		shuffle(b);
		boolean k = isSorted(z);
		boolean g =isSorted(s);
		double []l = inRange(z,1,5);
		double mm = maxsum(q);
		arraycopy(t, 3, t, 2, 4);
		System.out.println("Count = "+ count);
		System.out.println("Mode = "+mode);
		System.out.println("Major = "+major);
		System.out.println("x shuffled = "+Arrays.toString(x));
		System.out.println("isSortDouble = "+k);
		System.out.println("isSortString = "+g);
		System.out.println("Inrange = "+Arrays.toString(l));
		System.out.println("maxsum for array q = "+mm);
		System.out.println(Arrays.toString(t));
	}
	
	public static int count(int []d,int x)
	{
		int count = 0;
		for(int i =0;i<d.length;i++)
		{
			if(d[i]==x)
			{
				count++;
			}
		}
		return count;
	}
	public static int mode(int []d)
	{
		int maxcount = 0;		
		int mode = 0;
		for(int i = 0;i<d.length;i++)
		{	
			int count = 1;
			for(int j = i+1;j<d.length;j++)
			{
				if(d[i] == d[j])
				{
					count++;
				}
			}
			if(count>maxcount)
			{
				maxcount = count;
				mode = d[i];
			}
		}
		return mode;
	}
	public static boolean majority(int []d)
	{
		boolean major = false;
		for(int i = 0;i<d.length;i++)
		{	
			int count = 1;
			for(int j = i+1;j<d.length;j++)
			{
				if(d[i] == d[j])
				{
					count++;					
				}				
			}
//			System.out.println(count);			
			if(count>d.length/2)
			{
//				System.out.println(count);
//				System.out.println(d.length/2);
				major = true;
			}
//			System.out.println(d.length/2);
		}
		return major;
	}
	public static void insert(int []d,int l,int x)
	{		
		for(int i = d.length-2;i>=l;i--)
		{
			d[i+1] = d[i];			
		}
		d[l] = x;
		System.out.println("insert ="+Arrays.toString(d));
	}
	public static void remove(int []d,int i)
	{
		for(int j = i;j<d.length-1;j++)
		{
			d[j] = d[j+1];
		}
		d[d.length-1]=0;
		System.out.println("remove =" +Arrays.toString(d));
	}
	public static void shuffle(int []d)
	{
		Random rand = new Random();		
		int y;
		for(int i = 0;i<d.length;i++)
		{
			int j = rand.nextInt(d.length-1);
			y = d[j];
			d[j] = d[i];
			d[i] = y;
		}
		System.out.println("shuffle = "+Arrays.toString(d));
		
	}
	public static int[] shuffled(int []d)
	{
		int []x = new int[d.length];		
		Random rand = new Random();		
		int y;

		for(int i = 0;i<d.length;i++)
		{
			x[i]=d[i];
		}
		for(int i = 0;i<d.length;i++)
		{
			int j = rand.nextInt(d.length-1);
			y = x[j];
			x[j] = x[i];
			x[i] = y;
		}
		return x;
	}
	public static boolean isSorted(double []d)
	{
		boolean x = true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j =i+1;j<d.length;j++)
			{
				if(d[i]>d[j])
				{
					x = false;
				}
			}
		}
		return x;
	}
	public static boolean isSorted(String []d)
	{
		boolean x = true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j =i+1;j<d.length;j++)
			{
				if(d[i].length()>d[j].length())
				{
					x = false;
				}
			}
		}
		return x;
	}
	public static double[] inRange(double []d,double min,double max)
	{
		double []inRange = new double[d.length];
		int count = 0;
		for(int i = 0;i<d.length;i++)
		{
			if(d[i]<max && d[i]>min)
			{
				inRange[count] = d[i];
				count++;
			}
		}
		return inRange;
		
	}
	public static double maxsum(double []d)
	{		
		double max = Integer.MIN_VALUE;
		for(int i = 0;i<d.length;i++)
		{
			double sum = d[i];			
			for(int j = i+1;j<d.length-1;j++)
			{
				sum += d[j];
				//System.out.println("test sum = "+sum);
				if(sum>max)
				{
					max = sum;
					//System.out.println("max = " +max);
				}
			}
			//sum = Math.abs(sum);			
		}
		return 	max;
	}
	public static void arraycopy(int []a,int i,int []b,int j,int len)
	{
		int x = i;
		int y = j;
		while(x<i+len)
		{
			b[y] = a[x];
			x++;
			y++;
		}
	}
}
