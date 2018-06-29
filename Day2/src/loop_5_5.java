import java.util.Scanner;

public class loop_5_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1;

		while (n <= 100) {
			int i = 1;
			int count = 0;
			while (i <= n) {
				if (n % i == 0) {
					count++;
				}
				i++;
			}
			if (count == 2) {
				System.out.println(n);
			}
			n++;
		}

	}

}
