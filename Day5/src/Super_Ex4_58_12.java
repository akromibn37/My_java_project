import java.util.Scanner;

public class Super_Ex4_58_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		int []temp = new int[a.length()];
		for(int i=0;i<temp.length;i++)
		{
			temp[i] = Integer.parseInt("" + a.charAt(i));
		}
		String[][] s = new String[][]{{"xxxx","x--x","x--x","x--x","xxxx"},{"---x","---x","---x","---x","---x"},{"xxxx","---x","xxxx","x---","xxxx"}};
			
		for(int i=0;i<s[0].length;i++)
		{
			for(int j=0;j<a.length();j++)
			{
				System.out.print(s[temp[j]][i] + "\t");
			}
			System.out.println();
		}
		
	}

}
