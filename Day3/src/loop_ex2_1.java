import java.util.Scanner;

public class loop_ex2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i =1;	
		int sum = 0;
		int n;
		while(i<=10){
			System.out.println("input number "+i+" : ");
			n=sc.nextInt();
			sum = sum+n;
			i++;
			
		}
		System.out.println(sum);
	}

}
