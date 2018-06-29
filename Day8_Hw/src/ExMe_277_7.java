
public class ExMe_277_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isEquilateral(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a, b, c;
		a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
		b = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow(y1 - y3, 2));
		c = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow(y2 - y3, 2));
		if ((a == b) == (b == c)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isIsosceles(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a, b, c;
		a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
		b = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow(y1 - y3, 2));
		c = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow(y2 - y3, 2));

		if (((a == b) || (b == c)) && isTriangle(a, b, c)) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean isRightangled(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a, b, c;
		a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
		b = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow(y1 - y3, 2));
		c = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow(y2 - y3, 2));
		double max = max(a, max(b, c));
		if (max == a) {
			if (a == Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2))) {
				return true;
			} else {
				return false;
			}
		} else if (b == Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2))) {
			if (max < (a + c)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (c == Math.sqrt(Math.pow(b, 2) + Math.pow(a, 2))) {
				return true;
			} else {
				return false;
			}
		}

	}

	public static boolean isScalene(int x1, int y1, int x2, int y2, int x3, int y3) {
		double a, b, c;
		a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow(y1 - y2, 2));
		b = Math.sqrt(Math.pow((x1 - x3), 2) + Math.pow(y1 - y3, 2));
		c = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow(y2 - y3, 2));
		if (((a != b) && (b != c) && (a != c)) && isTriangle(a, b, c)) {
			return true;
		} else {
			return false;
		}
	}

	public static double max(double a, double b) {
		return a > b ? a : b;
	}

	public static boolean isTriangle(double a, double b, double c) {
		double max = max(a, max(b, c));
		if (max == a) {
			if (a < (b + c)) {
				return true;
			} else {
				return false;
			}
		} else if (max == b) {
			if (max < (a + c)) {
				return true;
			} else {
				return false;
			}
		} else {
			if (max < (a + b)) {
				return true;
			} else {
				return false;
			}
		}

	}

}
