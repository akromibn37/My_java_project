import java.util.Arrays;

public class array_extra3_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[]{1,2,1,3,8,5,4,6,8,4,2,5,6,1,2,1,0,0,1,2};
		int []b = new int[]{-1,0,1};
		int []c = new int[a.length];
		int sum;
		for(int i=1;i==a.length-1;i++){
			sum =0;
			for(int j=0;j<b.length;j++){
				sum = sum+b[j]*a[i+j-1];
			}
			c[i]=sum;
		}
		System.out.println(Arrays.toString(c));
	}

}
