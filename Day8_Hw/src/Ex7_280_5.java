
public class Ex7_280_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [][]z = new double[][]{{1,0,0},{0,1,0},{0,0,1}};
		boolean x = isZero(z);
		boolean y = isIdentity(z);
		boolean a = isLowerTriangular(z);
		boolean b = isUpperTriangular(z);
		System.out.println(x);
		System.out.println(y);
		System.out.println(a);
		System.out.println(b);
	}
	public static boolean isZero(double [][]d)
	{
		boolean z =true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				if(d[i][j] !=0)
				{
					z = false;
				}
			}
		}
		return z;
	}
	public static boolean isIdentity(double [][]d)
	{
		boolean z = true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				if(i ==j)
				{
					if(d[i][j] != 1)
					{
						z = false;
					}
				}
				else
				{
					if(d[i][j] !=0)
					{
						z = false;
					}
				}
			}
		}
		return z;
	}
	public static boolean isLowerTriangular(double [][]d)
	{
		boolean z = true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				if(j>i)
				{
					if(d[i][j] != 0)
					{
						z = false;
					}
				}				
			}
		}
		return z;
	}
	public static boolean isUpperTriangular(double [][]d)
	{
		boolean z = true;
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				if(i>j)
				{
					if(d[i][j] != 0)
					{
						z = false;
					}
				}				
			}
		}
		return z;
	}
}
