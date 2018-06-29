
public class loop_2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int n = 10;
		while (i <= n) {
			int j = 1;
			while (j <= n + i-1) {
				if (j >= n - i + 1 && j <= n + i - 1) {
					System.out.print("x");
				} else {
					System.out.print("-");
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
