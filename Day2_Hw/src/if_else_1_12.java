import java.util.Scanner;

public class if_else_1_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, p, q;
		System.out.println("Please input a,b,c,d");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		p = d * a + b * c;
		q = b * d;
		System.out.println(a + "/" + b + " + " + c + "/" + d + " = " + p + "/" + q);
		int max, min;
		if (p > q) {
			max = p;
			min = q;
		} else {
			max = q;
			min = p;
		}
		int i, x;
		i = 1;
		x = 1;
		while (i <= max) {
			if (max % i == 0 && min % i == 0) {
				x = i;
			}
			i++;
		}
		p = p / x;
		q = q / x;

		System.out.println("lowercase of p/q = " + p + "/" + q);

	}

}
