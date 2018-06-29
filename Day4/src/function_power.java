import java.util.Scanner;

public class function_power {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		int b = sc.nextInt();
		double z;
		z=power(a,b);
		System.out.println("power = " +z);
	}
	public static double power(double a,int b){
		double x=1;
		for(int i =1;i<=b;i++){
			x*=a;
					}
		return x;
	}

}
