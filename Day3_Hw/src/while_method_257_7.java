import java.util.Scanner;

public class while_method_257_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Todo again with two dimensional array and 1d array for days
		Scanner sc = new Scanner(System.in);
		double[][][] x = new double[2][2][2];
		for (int i = 0; i < x.length; i++) {
			System.out.println("input for campus " + (i+1));
			for (int j = 0; j < x[0].length; j++) {
				System.out.println("input for dept " + (j+1));
				for (int k = 0; j < x[0].length; k++) {
					System.out.print("input for day " + (k+1));
					x[i][j][k] = sc.nextDouble();
				}
			}
		}
		double sum = 0;
		double ss[] = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			sum = dayspent(x, 1, i);
			System.out.println("camp " + i + " day" + i + " = " + sum);
		}
		for (int i = 0; i < x.length; i++) {
			sum = departspent(x, 1, i);
			System.out.println("camp " + i + " dept" + i + " = " + sum);
		}
		for (int i = 0; i < x.length; i++) {
			sum = campspent(x, i);
			System.out.println("camp " + i + " = " + sum);
			ss[i] = sum;
		}
		double max = compare(ss);
		System.out.println("max = " + max);

	}

	public static double dayspent(double[][][] x, int day, int camp) {
		double sum = 0;
		for (int i = 0; i < x[0].length; i++) {
			sum += x[camp][i][day];
		}
		return sum;
	}

	public static double departspent(double[][][] x, int dept, int camp) {
		double sum = 0;
		for (int i = 0; i < x[1].length; i++) {
			sum += x[camp][dept][i];
		}
		return sum;
	}

	public static double campspent(double[][][] x, int camp) {
		double sum = 0;
		for (int i = 0; i < x[0].length; i++) {
			for (int j = 0; j < x[1].length; j++)
				sum += x[camp][i][j];
		}
		return sum;
	}

	public static double compare(double x[]) {
		double y;
		for (int j = 0; j < x.length; j++) {
			for (int i = 0; i < x.length - 1; i++) {
				if (x[i] > x[i + 1]) {
					y = x[i];
					x[i] = x[i + 1];
					x[i + 1] = y;

				}
			}
		}
		return x[x.length];
	}

}
