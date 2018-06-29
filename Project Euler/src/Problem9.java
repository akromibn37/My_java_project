
public class Problem9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;		
		boolean h;
		for(int i = 350;i>0;i--)
		{
//			System.out.println("a : " + i);
			for(int j=350;j>0;j--)
			{
//				System.out.println("b : "+j);
				
				h = check(i,j);
//				System.out.println(a+ ","+b);
				if(h){System.out.println("a : " + i + " ,b : " + j);}
			}
		}
	}
	public static boolean check(int a ,int b)
	{
		double total = Math.pow(a, 2) + Math.pow(b, 2);
		double t = Math.sqrt(total);
		if(Math.pow(t,2) == Math.pow(total,2))
		{
			System.out.println(t);
			return true;
			
		}
		return false;
	}

}
