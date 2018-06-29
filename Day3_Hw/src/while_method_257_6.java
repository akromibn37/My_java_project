import java.util.Arrays;
import java.util.Scanner;

public class while_method_257_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double dept[][] = new double[7][12];
		for (int i = 0; i < dept.length; i++) {
			System.out.println("Department store campus " + (i + 1));
			for (int j = 0; j < dept[0].length; j++) {
				System.out.print("Please input depatrment " + (j + 1) + " income : ");
				dept[i][j] = sc.nextDouble();

			}
		}
		double sumcamp = 0;
		double sumall = 0;
		double sumdept = 0;
		for (int i = 0; i < dept.length; i++) {
			sumcamp = sumcampus(dept, i);
			System.out.println("This " + (i+1) + " campus got " + sumcamp + "baht");
			sumall += sumcamp;
		}
		for (int i = 0; i < dept[0].length; i++) {
			sumdept = sumdepartment(dept, i);
			System.out.println("This " + (i+1) + " department got " + sumdept + "baht");
		}
		System.out.println("All summary is " + sumall + "baht");
		/*for (int i = 0; i <= dept.length; i++) {
			for (int j = 0; j < dept[0].length; j++) {
				System.out.print(dept[i][j] + "  ");
			}
			System.out.println();
		}*/
		System.out.println(Arrays.toString(dept[0]));
		System.out.println(Arrays.toString(dept[1]));

	}

	public static double sumcampus(double[][] dept, int x) {

		double sumcampus = 0;

		for (int j = 0; j < dept[0].length; j++) {

			sumcampus += dept[x][j];
		}

		return sumcampus;
	}

	public static double sumdepartment(double[][] dept, int x) {

		double sumdepartment = 0;

		for (int j = 0; j < dept.length; j++) {

			sumdepartment += dept[j][x];
		}

		return sumdepartment;
	}

}
