
public class loopfor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= n; i++) {
				if (i >= j) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
