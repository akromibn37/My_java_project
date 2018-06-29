import java.util.Scanner;

public class Ex5_271_11 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) 
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print("_");
			}
			System.out.println(s.charAt(i));
		}
		for (int i = s.length() - 1; i >= 0; i--) 
		{
			for (int j = 0; j < i; j++) 
			{
				System.out.print("_");
			}
			System.out.println(s.charAt(i));
		}
	}

}
