import java.util.Scanner;

public class loop_5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input number : ");
		int i = sc.nextInt();
		int n = 1;
		int sum = 0;
		while (n <= i) {
			if (i % n == 0) {
				sum++;
			}
			n++;
		}
		if(sum==2){
		System.out.println("prime number");
		}
		else{
			System.out.println("not prime number");
		}
	}

}
