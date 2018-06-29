import java.util.Scanner;

public class Ex5_272_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String a = sc.nextLine();
		int start = 0,stop = 0;
		for(int i =0;i<a.length();i++)
		{
			if(a.charAt(i)==' ' || a.charAt(i)=='.')
			{				
				System.out.println(a.substring(start, stop));
				start = i+1;
			}
			stop++;
		}
		System.out.println(a.substring(start,stop));
		sc.close();
	}	

}
