import java.util.Arrays;

public class Ex7_280_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = new int[][]{{1,2},{3,4}};
		int [][]b = new int[][]{{3,2,1,4},{1,2,3,4}};
		int max = maxsub(b);
		System.out.println(max);
		
	}
	public static int maxsub(int [][]d)
	{
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				for(int k = 0;k<d.length;k++)
				{
					for(int l=0;l<d[0].length;l++)
					{
						System.out.println("i = "+ i + " j = " + j + " k = " + k + " l = " + l);
						if((i!=k)||(j!=l)) 
						{
							int sum = 0;
							sum = d[i][j] -d[k][l];
							if(sum>max)
							{
								max = sum;
							}
							System.out.println("sum = "+sum);
						}
					}
				}
			}
		}
		System.out.println("d.length = " + d.length);
		System.out.println("d[0].length = " + d[0].length);
		return max;
	}

}
