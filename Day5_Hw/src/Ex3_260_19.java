import java.util.Arrays;
import java.util.Random;

public class Ex3_260_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[100];
		int[] y = new int[100];
		Random rand = new Random();
		int k, z,l=0;
		int j=0;
		while(j<x.length){	
			l++;
			if (j > 0) {
				//System.out.print(1);
				k = rand.nextInt(300);
				z = checksame(x, k);
				if (z == 0) {
					x[j] = k;
				} else {
					continue;
				}
			} else {
				x[j] = rand.nextInt(100);
			}
			//System.out.println(2);
			j++;
		}
		System.out.println(Arrays.toString(x));
		//System.out.println(x.length);
		//System.out.println(l);
		int i = 0;
		while ( i < y.length) {
			k = rand.nextInt(100);
			if (k % 2 == 0) {
				y[i] = k;
				i++;
			} else {
				continue;
			}
		}
		System.out.println(Arrays.toString(y));

	}	

	public static int checksame(int[] x, int y) {
		int k = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == y) {
				k = 1;
				break;
			}
		}
		return k;
	}

}
