import java.util.Arrays;
import java.util.Scanner;

public class array_extra3_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input size of array");
		int n;
		n=sc.nextInt();
		int []x=new int [n];
		for(int i =0;i<n;i++){
			System.out.println("input ");
			x[i] = sc.nextInt();
		}
		int []y =new int [n%2==0?n/2:n/2+1];
		for(int i =0;i<y.length;i++){
			y[i] = x[i]+x[n-i-1];
		}
		System.out.println(Arrays.toString(y));
		
	}

}
