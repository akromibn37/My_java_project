import java.util.Random;

public class while_method_257_6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x = new int[7][12];
		int sumall;
		sumall = filldata(x);
		incomedepart(x);
		System.out.println("All income of this department store is " + sumall + " baht");

	}

	public static int filldata(int[][] x) {
		Random rand = new Random();
		int sumall = 0;
		for (int i = 0; i < x.length; i++) {
			int sum = 0;
			System.out.println((i+1) + " campus is ");
			System.out.print((i+1) + " : ");
			for (int j = 0; j < x[0].length; j++) {
				x[i][j] = rand.nextInt(10);
				sum += x[i][j];
				sumall += x[i][j];
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
			System.out.println("All income for this campus is " + sum);
		}
		return sumall;
	}

	public static void incomedepart(int[][] x) {
		
		for (int i = 0; i < x[0].length; i++) {
			int sum = 0;
			System.out.print("Sum of " + (i+1) + " Department is ");
			for (int j = 0; j < x.length; j++) {
				sum += x[j][i];
			}
			System.out.print(sum + " baht");
			System.out.println();
		}
	}
}
