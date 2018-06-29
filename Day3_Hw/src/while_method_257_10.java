import java.util.Scanner;

public class while_method_257_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n,sum=0;
		double avg;
		int i=0;
		while(true){
			System.out.print("input n : ");
			n = sc.nextInt();
			
			if(n!=0)
			{
			sum+=n;
			i++;
			}
			else{
				break;
			}
		}
		avg = (double)sum/i;
		System.out.println("avg = "+avg+ " sum = " +sum);
	}

}
