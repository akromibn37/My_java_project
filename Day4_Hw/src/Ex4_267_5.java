
public class Ex4_267_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y, z;
		x = 7;
		y = 8;
		z = 5;
		int max;
		max = x;
		int i = 1;
		if (y > max) {
			max = y;
			i = 2;
		}
		if (z > max) {
			max = z;
			i = 3;
		}
		System.out.println(i);
		if (i == 1) {
			if (y + z > x) {
				System.out.println("Triangle");
			} else {
				System.out.println("not triangle");
			}
		} else if (i == 2) {
			if (x + z > max) {
				System.out.println("Triangle");
			} else {
				System.out.println("not triangle");
			}
		} else {
			if (x + y > z) {
				System.out.println("Triangle");
			} else {
				System.out.println("not triangle");
			}
		}

	}

}
