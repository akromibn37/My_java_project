import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex3_262_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal ans = new BigDecimal(Math.PI);
		ans = ans.setScale(6, RoundingMode.DOWN);

		double sum = 1;
		double pie;
		double i = 2;
		double j = 1;
		double k = 3;
		while (j < 1000) {

			sum *= (i / k);

			System.out.println("i,k,j : " + i + " " + k + " " + j);
			pie = sum * 4;
			BigDecimal bd = new BigDecimal(pie);
			bd = bd.setScale(6, RoundingMode.UP);
			System.out.println("sum = " + bd);
			System.out.println("ans = " + ans);
			System.out.println();

			if (bd != ans) {
				if (j == 1) {
					i += 2;
				} else {
					if (j % 2 == 0) {
						k += 2;
					} else {
						i += 2;
					}
				}
				j++;

			} else {
				System.out.println("count = " + j);
				break;
			}

		}
	}

}
