import java.util.Scanner;

public class loop_5_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number : ");
		int i =sc.nextInt();
		int n = 1;
		while(n<=i){
			if(i%n==0){
				System.out.print(" " +n);
			}
			n++;
		}

	}

}
