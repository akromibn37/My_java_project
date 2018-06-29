import java.util.Arrays;
import java.util.Random;

public class Ex4_268_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[50];
		filldata(x);
		System.out.println(Arrays.toString(x));
		int max = max(x);
		System.out.println("max sum for even is " + max);
		sumnumber(x);
	}

	public static void filldata(int[] x) {
		Random rand = new Random();
		for (int i = 0; i < x.length; i++) {
			x[i] = rand.nextInt(100);
		}		
	}

	public static int max(int[] x) {
		int max = Integer.MIN_VALUE;
		int even = 0;
		int odd = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] % 2 == 0) {
				even++;
				if (x[i] > max) {
					max = x[i];
				}
			}
			else
			{
				odd++;
			}
		}
		System.out.println("even = "+even);
		System.out.println("odd = "+odd);
		return max;
	}

	public static void sumnumber(int[] x) {
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x.length; j++) {
				if (x[i] + x[j] == 37) {
					System.out.println(x[i] + "," + x[j]);
					count++;
				}
			}
		}		
		System.out.println(count);
	}
}
