import java.util.Arrays;

public class Ex4_268_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		int x = 0;
		for (int k = 1; k <= 10000; k++) {
			int[] a = new int[1000];
			int i = 0;
			a[0] = k;
			i++;
			while (a[i - 1] != 1) {
				if (a[i - 1] % 2 == 0) {
					a[i] = a[i - 1] / 2;
				} else {
					a[i] = 3 * a[i - 1] + 1;
				}

				i++;
			}
			//System.out.println(Arrays.toString(a));
			if (i > max) {
				max = i;
				x = k;
			}
			System.out.println("k = " + k + ", times = " + i);
			System.out.println("max = " + max + ", k = " + x);
		}
		System.out.println("max times = " + max + ", k = " + x);

	}

}
