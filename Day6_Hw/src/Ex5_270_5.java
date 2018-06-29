import java.util.Scanner;

public class Ex5_270_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int count = 0;
		int ss = 0;
		// a.toLowerCase().contains(b.toLowerCase());
		boolean x = a.toLowerCase().contains(b.toLowerCase());
		int pos;
		// System.out.println(posi);
		for (int i = 0; i < a.length() && x;) {
			// System.out.println("in");
			pos = a.toLowerCase().indexOf(b.toLowerCase());
			StringBuilder sb = new StringBuilder(a);
			sb.delete(i, b.length() + pos);
			a = sb.toString();
			System.out.println("Remaining word is " + a);

			x = a.toLowerCase().contains(b.toLowerCase());
			ss += pos;
			count++;
			System.out.println("Position " + count + " = " + ss);
			ss += b.length();
			i = 0;

		}

		System.out.println("All count = " + count);
		sc.close();
	}
	
//	Scanner sc = new Scanner(System.in);
//	String s1,s2;
//	s1 = sc.nextLine();
//	s2 = sc.nextLine();
//	if(s1.indexOf(s2)==-1)
//	{
//		System.out.println("nothing");
//		return;
//	}
//	int i =0;
//	while(i>=0 && i<s1.length())
//	{
//		i = s1.indexOf(s2,i);
//		if(i == -1)
//		{
//			break;
//		}
//		System.out.println(i);
//		i++;
//	}
}
