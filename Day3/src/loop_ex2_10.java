
public class loop_ex2_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum =0;
		int n = 10000;
		for(int i =1;i<=n;i++)
		{
			int k =2*i-1;
			sum+=1.0/k;
			i++;
			k=2*i-1;
			sum-=1.0/k;
		}
		System.out.println(sum*4);
	}

}
