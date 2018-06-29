
public class testString {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		long a = System.currentTimeMillis();
		String s = "";
		int n = 10000;
		for(int i = 0;i<n;i++)
		{
			s= s+ Math.random();
		}
		long b = System.currentTimeMillis();
		System.out.println(b-a);
		
		a = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n*100;i++)
		{
			sb.append(Math.random());
		}
		b = System.currentTimeMillis();
		System.out.println(b-a);
	}

}
