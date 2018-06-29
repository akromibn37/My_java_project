import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex3_260_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.print("input amount of student : ");
		n = sc.nextInt();
		int[][] a = new int[n][5];
		Random rand = new Random();
		for (int i = 0; i < a.length; i++) {
			System.out.print("Student " + (i+1) + "  ");
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = rand.nextInt(20);
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		double []eachpeo = new double[n];
		double []eachtime = new double[5];
		for(int i=0;i<eachpeo.length;i++)
		{
			eachpeo[i]=eachpeople(a,i)/5;
		}
		System.out.print("each student avg = ");
		System.out.println(Arrays.toString(eachpeo));
		for(int i=0;i<eachtime.length;i++)
		{
			eachtime[i]=eachtime(a,i)/n;
		}
		System.out.print("each time avg = ");
		System.out.println(Arrays.toString(eachtime));
		

	}

	public static double eachpeople(int[][] a, int n) {
		double sum = 0;

		for (int j = 0; j < a[0].length; j++) {
			sum += a[n][j];
		}

		return sum;
	}
	public static double eachtime(int[][] a, int n) {
		double sum = 0;

		for (int j = 0; j < a.length; j++) {
			sum += a[j][n];
		}

		return sum;
	}

}
