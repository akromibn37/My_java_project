import java.util.Arrays;
import java.util.Scanner;

public class array_extra3_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[10];
		for (int i = 0; i < x.length; i++) {
			x[i] = sc.nextInt();
		}
		for(int j=0;j<x.length;j++){
			int min = Integer.MAX_VALUE;
			int min_index = -1;
			for(int i =0;i<x.length-j;i++){
				if(x[i]<min){
					min = x[i];
					min_index =i;
				}
			}
			int t = x[x.length-j-1];
			x[x.length-j-1] = x[min_index];
			x[min_index] = t;
		}
		System.out.println(Arrays.toString(x));
	}

}
