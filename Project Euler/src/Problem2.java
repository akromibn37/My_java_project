import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

	public static void main(String[] args)
	{
		long i = 0;
		int j = 0;
		long [] x = {1,2,3};
		double sum = 2;
		while(i<4000000)
		{
			i = x[2];
			if(j%2==0){sum+=i;}
			System.out.println(sum);
			x[0] = x[1];
			x[1] = i;
			x[2] = x[0] + x[1];
			System.out.println(Arrays.toString(x));
			j++;
		}
		System.out.println("Total sum : " + sum);
	}
}
