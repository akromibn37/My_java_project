import java.util.Arrays;
import java.util.Scanner;

public class while_method_257_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] odd = new int[5];
		int[] even = new int[5];
		int i = 0;
		int j = 0, k = 0;
		int n;
		Scanner sc = new Scanner(System.in);
		while (i < 10) {
			n = sc.nextInt();
			if (n % 2 == 0) {
				even[j] = n;
				j++;
			} else {
				odd[k] = n;
				k++;
			}
			i++;
		}
		int maxodd = maxormin(odd, 1);
		int minodd = maxormin(odd, 0);
		int maxeven = maxormin(even, 1);
		int mineven = maxormin(even, 0);
		System.out.println(Arrays.toString(odd));
		System.out.println(Arrays.toString(even));
		System.out.println("maxeven = " + maxeven + ",mineven = " + mineven);
		System.out.println("maxodd = " + maxodd + ",minodd = " + minodd);

	}

	public static int maxormin(int[] x, int k) {
		int y;
		for (int j = 0; j < x.length; j++) {
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					y = x[i];
					x[i] = x[i + 1];
					x[i + 1] = y;

				}
			}
		}
		if (k == 0) {
			// min
			return x[0];
		} else {
			// max
			return x[x.length-1];
		}
	}

}
