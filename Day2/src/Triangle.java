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
				System.out.println("��������������ҹ");
			} else if (m < n) {
				System.out.println("����������������");
			} else {
				System.out.println("��������������ҡ");
			}
		} else {
			System.out.println("This is not triangle");
			return;
		}
		if(a==b && b==c){
			System.out.println("��ҹ���");
		}
		else if(a==b || b==c || a==c){
			System.out.println("˹�Ҩ���");
		}
		else{
			System.out.println("��ҹ������");
		}

	}

}
