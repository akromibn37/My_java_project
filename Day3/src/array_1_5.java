import java.util.Scanner;

public class array_1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int []x=new int[10];
		int count=0;
		for(int i=0;i<x.length;i++){
			System.out.print("Please input a number: ");
			x[i]=sc.nextInt();
			if(x[i]%2==0)
			{				
				count++;
			}
		}
		
			System.out.println(count);
		
	}

}
