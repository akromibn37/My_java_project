
public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1000;
		int sum = 0;
		for(int i=0;i<x;i++)
		{
			if((i%3==0)||(i%5==0))
			{
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
