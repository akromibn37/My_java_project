import java.util.Arrays;
import java.util.Scanner;

public class array_1_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[10];
		int y;
		for(int i=0;i<x.length;i++){
			System.out.print("Please input a number: ");
			x[i]=sc.nextInt();
			
		}
		for (int j = x.length-1; j >0; j--) {
			for (int i = x.length-1; i >0; i--) {
				if (x[i] > x[i - 1]) {
					y = x[i];
					x[i] = x[i - 1];
					x[i - 1] = y;

				}
			}
		}
		System.out.println(Arrays.toString(x));
	}

}
