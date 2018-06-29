import java.util.Scanner;

public class Ex3_260_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m,n;
		Scanner sc = new Scanner(System.in);
		System.out.print("input m,n : ");
		m =sc.nextInt();
		n = sc.nextInt();
		if(m>=n)
		{
			for(int i=m;i>=n;i--){
				System.out.print(i + " ");
			}
		}
		System.out.println();
		if(m>=n)
		{
			for(int i=n;i<=m;i++){
				System.out.print(i + " ");
			}
		}
	}

}
