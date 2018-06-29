import java.util.Random;

public class while_method_257_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[][] = new int[100][7];
		filldata(x);
		showdata(x, 10);
		showalldata(x);

	}

	public static void filldata(int x[][]) {
		Random rand = new Random();
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				if (j < 5) {
					x[i][j] = rand.nextInt(10);
				} else {
					x[i][j] = rand.nextInt(100);
				}
			}
		}
	}

	public static void showdata(int x[][], int y) {
		double hw = 0, midterm, finalmark, allmark;
		System.out.println("student number " + y);
		for (int i = 0; i < x[0].length; i++) {
			System.out.print(x[y - 1][i] + " ");
			if (i < 5) {
				hw += x[y - 1][i];
			}
		}
		hw = 20 * hw / 50;
		midterm = 30 * (x[y - 1][5]) / 100;
		finalmark = 50 * (x[y - 1][6]) / 100;
		allmark = hw + midterm + finalmark;
		System.out.println();
		System.out.println("Student number " + y + " Score is ");
		System.out.println("homework = " + hw + "% ,midterm = " + midterm + "% ,final = " + finalmark + " %");
		System.out.println("Sumall = " + allmark + " %");
		System.out.println();

	}

	public static void showalldata(int x[][]) {

		for (int i = 0; i < x.length; i++) {
			System.out.print((i + 1) + " : ");
			for (int j = 0; j < x[0].length; j++) {
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}

	}

}
