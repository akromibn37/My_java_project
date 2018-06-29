
public class loopfor6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		for (int j = 1; j <= n; j++) {
			for (int i = 1; i <= n; i++) {
				if (i == j+n/2 || i== j-n/2 || i==n-j+1-n/2 || i==n-j+1+n/2) {
					System.out.print("x");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
