import java.util.Scanner;

public class Ex5_269_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		a = deletestring(a);
		System.out.println(a);
	}
	public static String deletestring(String a)
	{
		StringBuilder sb = new StringBuilder(a);
		sb.deleteCharAt(0);
		String s = sb.toString();
		return s;
	}

}
