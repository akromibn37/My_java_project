
public class loop_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while (i <= 10) {
			int j = 1;
			while (j <= 10 - i) {
				System.out.print("-");
				j++;
			}

			while (10 >= j) {
				System.out.print("x");
				j++;
			}

			System.out.println();
			i++;
		}

	}

}
