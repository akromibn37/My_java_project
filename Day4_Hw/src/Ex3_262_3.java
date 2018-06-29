import java.util.Scanner;

public class Ex3_262_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int []temp = new int[a.length()];
		for(int i=0;i<temp.length;i++)
		{
			temp[i] = Integer.parseInt("" + a.charAt(i));
		}
		for(int j=temp.length-1;j>=0;j--)
		{
			System.out.print(temp[j]);
		}
		
	}

}
