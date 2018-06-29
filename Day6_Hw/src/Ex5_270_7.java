import java.util.Scanner;

public class Ex5_270_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = "Palindrome";
		for(int i = 0;i<s1.length()/2;i++)
		{
			if(s1.charAt(i)!=s1.charAt(s1.length()-i-1))
			{
				s2 = "Not Palindrome";
			}
		}
		System.out.println(s2);
	}

}
