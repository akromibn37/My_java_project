import java.util.Scanner;

public class array_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []x=new int[10];
		int count=0;
		for(int i=0;i<x.length;i++){
			System.out.print("Please input a number: ");
			x[i]=sc.nextInt();
			
		}
		for(int j =x.length-1;j>=0;j--)
		{
			System.out.println(x[j]);
		}
	}

}
