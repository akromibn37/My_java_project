
public class loop_5_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		int n = 1;
		while (count <= 100) {
			int i = 1;
			int x = 0;
			while (i <= n) {
				if (n % i == 0) {
					x++;
				}
				i++;
			}
			if (x == 2) {
				System.out.println("number " + n + " is a prime number rank " + count);
				count++;
			}
			n++;
		}
	}

}
