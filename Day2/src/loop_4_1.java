import java.util.Scanner;

public class loop_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b;
		System.out.print("Please input 2 numbers : ");
		a = sc.nextInt();
		b = sc.nextInt();
		if(a<b){
			System.out.println("b is greater than a");
		}
		else if(a==b){
			System.out.println("a is equal to b");
		}
		else{
			System.out.println("a is greater than b");
		}
	}

}
