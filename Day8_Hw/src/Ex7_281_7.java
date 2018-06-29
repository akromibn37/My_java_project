import java.util.Arrays;

public class Ex7_281_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []x =new int []{1,2,3,4,5,6,7,0,-20,-300,-100,1000,2537,2559,2735};
		int []maxmin = maxmin(x);
		System.out.println(Arrays.toString(maxmin));
	}
	public static int[] maxmin(int []d)
	{
		int []maxmin = new int[2];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i =0;i<d.length;i++)
		{
			if(d[i]>max)
			{
				max = d[i];
			}
			if(d[i]<min)
			{
				min = d[i];
			}
		}
		maxmin[0] = max;
		maxmin[1] = min;
		return maxmin;
	}

}
