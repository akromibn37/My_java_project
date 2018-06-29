
public class function_sin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sin(Math.PI/2));
	}
	public static double sin(double x){
		double result =0;
		for(int i =1;i<=17;i=i+2){
			if(i%4==1){
				result =result + power(x,i)/factorial(i);
			}
			else{
				result=result - power(x,i)/factorial(i);
			}
		}
		return result;
	}
	public static double power(double a,int b){
		double x=1;
		for(int i =1;i<=b;i++){
			x*=a;
					}
		return x;
	}
	public static double factorial(int n){
		//recursive function
		if(n==1||n==0){
			return 1;
		}
		return n*factorial(n-1);
	}
}
