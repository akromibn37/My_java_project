import java.util.Scanner;

public class Ex4_267_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, c, d, e, f;
		Scanner sc = new Scanner(System.in);
		System.out.println("Start time : Hour(1-12) and minute(0-60) : ");
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println("Stop time : Hour(1-12) and minute(0-60) : ");
		c = sc.nextInt();
		d = sc.nextInt();
		if (d < b) {
			d += 60;
			c -= 1;
		}
		e = c - a;
		f = d - b;
		System.out.println("Diff = " + e + " hour " + f + " minutes");

	}

}
