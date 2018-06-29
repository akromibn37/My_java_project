import java.util.Scanner;

public class Ex5_273_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Input 12 numbers : ");
		Scanner sc = new Scanner(System.in);
		int []d = new int[12];
		int sum = 0;
		for(int i=0;i<d.length;i++)
		{
			d[i] = sc.nextInt();
		}
		for(int i = 0;i<d.length;i++)
		{
			sum+=((14-(i+1))*d[i]);
		}
		int d13 = (11-sum%11)%10;
		System.out.println(d13);
	}

}
