import java.util.Arrays;
import java.util.Scanner;

public class array_1_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[9];
		int y;
		for (int i = 0; i < x.length; i++) {
			System.out.print("Please input a number: ");
			x[i] = sc.nextInt();

		}
		for (int j = 0; j < x.length; j++) {
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					y = x[i];
					x[i] = x[i + 1];
					x[i + 1] = y;

				}
			}
		}
		System.out.println(Arrays.toString(x));
		if (x.length % 2 == 0) {
			y = (x[x.length / 2 - 1] + x[x.length / 2]) / 2;
		} else {
			y = x[x.length / 2];
		}
		System.out.println("Median = " + y);
	}

}
