import java.util.Arrays;
import java.util.Scanner;

public class array_extra3_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		System.out.println("input index : ");
		int index = sc.nextInt();		
		System.out.println("input v : ");
		int v = sc.nextInt();

		for (int i = x.length-1; i >index; i--) {
			x[i] = x[i-1];
		}
		x[index] = v;
		System.out.println(Arrays.toString(x));

	}

}
