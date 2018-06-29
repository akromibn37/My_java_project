import java.util.Scanner;

public class while_method_257_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sum=0,n;
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=5;i++){
			n=sc.nextDouble();
			sum+=n;
		}
		double avg = sum/5;
		System.out.println("sum = "+sum +" avg = "+avg);
	}

}
