
public class Problem6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sumsq = sum(100);
		int sqsum = sq(100);
		int diff = sqsum - sumsq;
		System.out.println(diff);
	}
	public static int sum(int x)
	{
		int sum =0;
		for(int i =0;i<=x;i++)
		{
			sum +=i;
			System.out.println(i+" : " + sum);
		}
		System.out.println(sum);
		return (int) Math.pow(sum, 2);
	}
	public static int sq(int x)
	{
		int sum = 0;
		for(int i = 0;i<=x;i++)
		{
			sum+= Math.pow(i,2);
			System.out.println(i+" : " + sum);
		}
		System.out.println(sum);
		return sum;
	}
}
