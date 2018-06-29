
public class if_else_3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		n = 10;
		double sumout = 0.0;
		double sum = 0;	
		for (int i = 1; i <= n; i++) {
			double count = 0;
			double k = 1;
			while (k <= i) {
				count =count+ (1 / k);
				System.out.println("i = " + i + " k = " + k + " sumin = " + count);
				k++;
			}
			sumout += count;
			System.out.println("H" + i + " = " + sumout);
			sum+=sumout;
		}
		System.out.println(sum);
	}

}
