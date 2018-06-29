import java.util.Random;
import java.util.Scanner;

public class Ex3_260_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Random rand = new Random();
		n = rand.nextInt(10);
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while(x!=n)
		{
			
			if(x>n)
			{
				System.out.println("Smaller");
			}
			else{
				System.out.println("Greater");
			}
			x=sc.nextInt();
		}
		System.out.println("Correct");
	}

}
