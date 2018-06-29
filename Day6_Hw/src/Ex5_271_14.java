import java.util.Scanner;

public class Ex5_271_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		String one = sc.nextLine();
		String two = sc.nextLine();
		
		StringBuilder sb = new StringBuilder(two);
		sb = sb.delete(0, m);
		two = sb.toString();
		System.out.println(two);
		StringBuilder sa = new StringBuilder(one);
		sa = sa.insert(n, two);
		System.out.println(sa);
		sc.close();
		
	}

}
