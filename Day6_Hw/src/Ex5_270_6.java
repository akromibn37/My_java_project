import java.util.Scanner;

public class Ex5_270_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int num = sc.nextInt();
		num+=1;
		if (num > a.length() || num < 0) {
			num = a.length();
		}
		StringBuilder sb = new StringBuilder(a);
		sb = sb.insert(num, b);
		System.out.println(sb);
		sc.close();
	}
//	Hellooopopopoo
//	Swasdedidididi
}
