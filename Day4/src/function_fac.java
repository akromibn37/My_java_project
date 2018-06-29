
public class function_fac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =7;
		double x =factorial(n);
		System.out.println("facorial = " +x);
	}
	public static double factorial(int n){
		//recursive function
		if(n==1||n==0){
			return 1;
		}
		return n*factorial(n-1);
	}

}
