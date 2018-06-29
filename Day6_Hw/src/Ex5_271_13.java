import java.util.Scanner;

public class Ex5_271_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = count(s);
		System.out.println(count);
		sc.close();
		
	}
	public static int count(String s)
	{
		return s.length();
	}

}
