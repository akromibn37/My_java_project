import java.util.Arrays;

public class Ex7_281_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double [][]x = new double[][]{{1,2,3,4,5},{5,4,3,2,1}};
		double [][]y = transpose(x);
		System.out.println(Arrays.toString(x[0]));
		System.out.println(Arrays.toString(x[1]));
		System.out.println(Arrays.toString(y[0]));
		System.out.println(Arrays.toString(y[1]));
		System.out.println(Arrays.toString(y[2]));
		System.out.println(Arrays.toString(y[3]));
		System.out.println(Arrays.toString(y[4]));
		
	}
	public static double[][] transpose(double [][]d)
	{
		double [][]ret = new double[d[0].length][d.length];
		for(int i = 0;i<d.length;i++)
		{
			for(int j = 0;j<d[0].length;j++)
			{
				ret[j][i] = d[i][j];
			}
		}
		return ret;
	}

}
