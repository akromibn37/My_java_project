import java.util.Arrays;
import java.util.Scanner;

public class Ex5_272_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String a = sc.nextLine();		
		String []s = new String[10];
		int x=0;
		int i =0;
		int count = 0;
		for(;;)
		{
			x=a.lastIndexOf(" ");
			if(x!=-1)
			{			
			s[i] = a.substring(x+1);
			i++;
			StringBuilder sb = new StringBuilder(a);
			sb = sb.delete(x, a.length());
			System.out.println(sb);
			a = sb.toString();
			System.out.println(Arrays.toString(s));
			count++;
			}
			else
			{
				count++;
				x=0;				
				s[i] = a.substring(x);
				System.out.println(Arrays.toString(s));
				break;
				
			}
			
		}
		for(int j=0;j<count;j++)
		{
			
			System.out.print(s[j] + " ");
			
		}
		sc.close();
				

	}

}
