import java.util.Arrays;
import java.util.Scanner;

public class Ex5_269_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int a = transform(s);
		System.out.println(a);

	}

	public static int transform(String s) {
		int[] a = new int[s.length()];
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I':
				a[i] = 1;
				break;
			case 'V':
				a[i] = 5;
				break;
			case 'X':
				a[i] = 10;
				break;
			case 'L':
				a[i] = 50;
				break;
			case 'C':
				a[i] = 100;
				break;
			case 'D':
				a[i] = 500;
				break;
			case 'M':
				a[i] = 1000;
				break;

			}
			System.out.println(Arrays.toString(a));
		}
		for (int i = 0; i < a.length; i++) {
			if (i < a.length - 1) {
				if (a[i] < a[i + 1]) {
					sum -= a[i];
				} else {
					sum += a[i];
				}
			} else {
				sum += a[i];
			}
			System.out.println(sum);
		}

		return sum;
	}

}
