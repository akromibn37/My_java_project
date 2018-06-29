import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Ex4_267_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		int a = sc.nextInt();
		System.out.println(NumberFormat.getNumberInstance(Locale.US).format(a));	
		
	}

}
