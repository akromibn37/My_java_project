import java.util.Arrays;
import java.util.Scanner;

public class Ex5_270_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String test = "";
		String[] PalinDrome = new String[100];
		boolean logic = true;
		int count = 0;

		for (int i = 0; i < s1.length(); i++) 
		{
			for (int j = i + 1; j < s1.length(); j++) 
			{
				test = s1.substring(i, j);				
				logic = palindrome(test);				
				if (logic) 
				{
					PalinDrome[count] = test;
					count++;
				}
			}
		}
		int max = Integer.MIN_VALUE;
		int co = 0;
		
		for(int i =0;i<count;i++)
		{
			if(PalinDrome[i].length()>max)
			{
				max = PalinDrome[i].length();
				co = i;
			}
		}
		System.out.println("Longest PalinDrome is : " + PalinDrome[co]);
		System.out.println(Arrays.toString(PalinDrome));

	}

	public static boolean palindrome(String s1) 
	{
		boolean logic = true;
		for (int i = 0; i < s1.length() / 2; i++) 
		{
			if (s1.charAt(i) != s1.charAt(s1.length() - i - 1)) 
			{
				logic = false;
			}			
		}
		return logic;

	}

}