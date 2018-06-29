import java.util.Scanner;

public class Ex5_270_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		if(k<0||k>s1.length())
		{
			s1 = s1+s2;
		}
		else
		{
			s1 = s1.substring(0,k) +s2 +s1.substring(k);
		}
		System.out.println(s1);
		sc.close();
	}

}
