
public class loopfor4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= n*2; i++) {
				if (i >= j && i<= 2*n-j) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
