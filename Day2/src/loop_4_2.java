import java.util.Scanner;

public class loop_4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner dc = new Scanner(System.in);
		int a, b;
		System.out.print("Please input two numbers : ");
		a = dc.nextInt();
		b = dc.nextInt();
		int k = a;
		while (true) {
			if(a%k==0 && b%k==0){
			break;}
			k--;
		}
		System.out.println(k);

	}

}
