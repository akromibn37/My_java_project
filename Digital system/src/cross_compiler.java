
public class cross_compiler {
	public static int fac(int n) {
		if (n == 1) {
			return 1;
		} else {
			return (n * (fac(n -1)));
		}
	}

	public static int test(int a) {
		return a + 3;
	}

	public static int tet(int b) {
		return (b - (test(b + 1)));
	}

	public static int tex(int c) {
		return (c / (test(10)));
	}

	public static void main(String[] args) {
		System.out.println(fac(6));
		System.out.println(test(3));
	}
}
