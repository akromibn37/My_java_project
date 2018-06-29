
public class recursivetest {

	public static long fac(int n){
		long r =1; //2,147,483,647
		for(int i=1;i<=n;i++){
			r=r*i;
		}
		return r;
	}
	public static long fac2(int n){
		if(n==0||n==1) return 1;
		return n*fac2(n-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fac(5));
		System.out.println(fac2(5));
		long start,stop;
		start = System.currentTimeMillis();
		for(int i=0;i<=10000;i++)
		{
			fac(i);
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		
		start = System.currentTimeMillis();
		for(int i=0;i<=10000;i++)
		{
			fac2(i);
		}
		stop = System.currentTimeMillis();
		System.out.println(stop-start);
		
	}

}
