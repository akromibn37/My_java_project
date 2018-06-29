import java.util.Scanner;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		System.out.println("Please input 3 number : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		int max, x, y;
		if ((a >= b) && (a >= b)) {
			max = a;
			x = b;
			y = c;

		} else if ((b >= a) && (b >= c)) {
			max = b;
			x = a;
			y = c;
		} else {
			max = c;
			x = a;
			y = b;
		}

		if ((x + y) > max) {
			int m, n;
			m = max * max;
			n = x * x + y * y;
			if (m > n) {
				System.out.println("สามเฟลี่ยมมุมป้าน");
			} else if (m < n) {
				System.out.println("สามเฟลี่ยมมุมแหลม");
			} else {
				System.out.println("สามเหลี่ยมมุมฉาก");
			}
		} else {
			System.out.println("This is not triangle");
			return;
		}
		if(a==b && b==c){
			System.out.println("ด้านเท่า");
		}
		else if(a==b || b==c || a==c){
			System.out.println("หน้าจั่ว");
		}
		else{
			System.out.println("ด้านไม่เท่า");
		}

	}

}
