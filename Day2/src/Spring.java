import java.util.Scanner;

public class Spring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double G, OD, n, k, d0, d;
		G = 11.5e6;
		OD = 0.5;
		n = 8;
		k = 2.681829632240412;
		d0 = 0;
		d = 0;
		int i = 0;
		while (i < n) {
			d = Math.pow(((8 * k * n * Math.pow((OD - d0), 3)) / G), 0.25);
			if (d - d0 <= 10e-6) {
				System.out.println("d0 = " + d0);
				System.out.println("d = " + d);
				System.out.println("different = " + (d - d0));
				break;
			}
			System.out.println(i + 1 + " round");
			System.out.println("d0 = " + d0);
			System.out.println("d = " + d);
			System.out.println();
			d0 = d;
			i++;
		}
		System.out.println("Diameter(d) = " + d);

	}

}
