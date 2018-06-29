import java.util.Scanner;

public class while_method_257_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("How many number?? :");
		n = sc.nextInt();
		double sum = 0;
		double avg;
		double x;
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			System.out.print("Number " + i + " : ");
			x = sc.nextDouble();
			sum += x;
			max = max(x, max);
			min = min(x, min);
		}
		avg = sum / n;
		System.out.println("average,max,min : " + avg + "," + max + "," + min);
	}

	public static double max(double x, double max) {
		if (x > max) {
			max = x;
		}
		return max;
	}

	public static double min(double x, double min) {
		if (min > x) {
			min = x;
		}
		return min;
	}

}
