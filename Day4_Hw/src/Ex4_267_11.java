
public class Ex4_267_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 1, b = 1, c = 1;
		double[] d = new double[1000];
		while (Math.pow(c, 2) <= 250000) {
			/*
			 * c = Math.pow(a, 2) + Math.pow(b, 2); if (c == (int) c) {
			 * System.out.println("a = " + a + ", b= " + b); } a++; if(a==22) {
			 * a=1; b++; }
			 */
			int j=0;
			for (a = 1; a <= 500; a++) {
				for (b = 1; b <= 500; b++) {
					c = Math.pow(a, 2) + Math.pow(b, 2);
					c = Math.sqrt(c);
					
					if (c == (int) c && c <= 500) {
						int count = 0;						
						for (int i = 0; i < d.length; i++) {
							
							if (c == d[i]) {
								count++;
							}
						}
						if (count == 0) {
							System.out.println("a = " + a + ", b = " + b + ", c = " + c);
							d[j]=c;
							j++;
							//System.out.println(j);
							//System.out.println(Arrays.toString(d));
						}
					}
					if (b == 500 && a < 500) {
						c = 1;
					}
				}
			}
		}

	}

}
