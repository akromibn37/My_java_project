import java.util.Scanner;

public class loop_ex2_1dot5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i =1;	
		int sum = 0;
		int n,N;
		int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
		double avg;
		System.out.println("Please input amount of number : ");
		N = sc.nextInt();
		while(i<=N){
			System.out.print("input number "+i+" : ");
			n=sc.nextInt();
			if(i==1){
				System.out.println("min = "+min + "max = " +max);
			}
			sum = sum+n;
			if(n>max){
				max=n;
			}
			if(n<min){
				min = n;
			}
			i++;			
		}
		avg=(double)sum/N;
		System.out.println("avg = "+ avg + " max = " + max + " min =" +min);
	}

}
