import java.util.Scanner;

public class loop_ex2_1_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i =1;	
		int sum = 0;
		int n;
		int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
		double avg;
		while(i<=10){
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
		avg=sum/10.0;
		System.out.println("avg = "+ avg + " max = " + max + " min =" +min);
	}

}
