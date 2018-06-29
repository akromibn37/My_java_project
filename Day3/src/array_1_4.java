import java.util.Scanner;

public class array_1_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []x=new int[10];
		
		for(int i=0;i<x.length;i++){
			System.out.print("Please input a number: ");
			x[i]=sc.nextInt();			
		}
		for(int i=0;i<x.length;i++){
				
			if(x[i]%2==0)
			{
				System.out.println(x[i]);
			}
		}
		
	}

}
