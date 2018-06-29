import java.util.Arrays;
import java.util.Scanner;

public class Ex5_270_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String []s = new String[n];
		int []checklong = new int[n];
		int max = Integer.MIN_VALUE;
		int index = 0;
		for(int i = 0;i<n;i++)
		{
			s[i] = sc.nextLine();
			checklong[i] = s[i].length();
			if(checklong[i] > max)
			{
				max = checklong[i];
				index = i;
			}
		}
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString(checklong));
		System.out.println(s[index]);
		sc.close();
	}	

}
