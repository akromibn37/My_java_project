import java.util.Scanner;

public class J103_Exam_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input n : ");
		int n = sc.nextInt();
		double ans = 0;
		for(int i =1;i<=n;i++)
		{
			ans +=Math.pow(n, i);
			System.out.println(ans);
		}
		ans = Math.sqrt(ans);
		System.out.println(ans);
	}

}
