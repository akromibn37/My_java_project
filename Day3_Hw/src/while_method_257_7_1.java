import java.util.Random;

public class while_method_257_7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] one = new int[5][5];
		int[][] two = new int[5][5];
		int[][] three = new int[5][5];

		filldata(one);
		filldata(two);
		filldata(three);
		int x1, x2, x3;

		x1 = caloutdaycome(one, 1);
		x2 = caloutdaycome(two, 1);
		x3 = caloutdaycome(three, 1);
		System.out.println("Tuesday outcome for first campus is " + x1);
		System.out.println("Tuesday outcome for second campus is " + x2);
		System.out.println("Tuesday outcome for third campus is " + x3);
		System.out.println();

		x1 = caldepartoutcome(one, 3);
		x2 = caldepartoutcome(two, 3);
		x3 = caldepartoutcome(three, 3);
		System.out.println("Depart 4 outcome for first campus is " + x1);
		System.out.println("Depart 4 outcome for second campus is " + x2);
		System.out.println("Depart 4 outcome for third campus is " + x3);
		System.out.println();

		System.out.println("First campus");
		x1 = sumdata(one);
		System.out.println();
		System.out.println("Second campus");
		x2 = sumdata(two);
		System.out.println();
		System.out.println("Third campus");
		x3 = sumdata(three);
		System.out.println();
		System.out.println("first campus is " + x1);
		System.out.println("second campus is " + x2);
		System.out.println("third campus is " + x3);
		System.out.println();
		int max = x1;
		if(max>x2){
			if(x3>x1){
				max = x3;
				System.out.println("campus 3 is the greatest " +max);
			}
			else{
				System.out.println("campus 1 is the greatest " +max);
			}
		}
		else if(x2>max){
			if(x2>x3){
				max=x2;
				System.out.println("campus 2 is the greatest " +max);
			}
			else if(x3>x2){
				max = x3;
				System.out.println("campus 3 is the greatest " +max);
			}
		}

	}

	public static void filldata(int[][] x) {
		Random ran = new Random();
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				x[i][j] = ran.nextInt(10);
			}
		}
	}

	public static int caloutdaycome(int[][] x, int y) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i][y];
		}
		return sum;
	}

	public static int caldepartoutcome(int[][] x, int y) {
		int sum = 0;
		for (int i = 0; i < x[0].length; i++) {
			sum += x[y][i];
		}
		return sum;
	}

	public static int sumdata(int[][] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				sum += x[i][j];
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
		return sum;
	}

}
