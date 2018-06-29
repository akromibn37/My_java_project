import java.util.Scanner;

public class Ex5_269_1 {

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
		sb.deleteCharAt(a.length()-1);
		String s = sb.toString();
		return s;
	}

}
