import java.util.Scanner;

public class loop_ex_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n,i=0;
		n=sc.nextInt();		
		while(n!=0){
			int j=1;
			while(j<=n)
			{
				System.out.print("*");
				j++;
				i++;
			}
			System.out.println();
			n--;
			
		}
		System.out.println(i);
	}

}
