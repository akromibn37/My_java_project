import java.util.Scanner;

public class Ex3_260_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0,n;
		double avg;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Scanner sc =new Scanner(System.in);
		for(int i =0;i<10;i++)
		{
			n = sc.nextInt();
			sum+=n;
			if(n>max)
			{
				max = n;
			}
			if(n<min)
			{
				min =n;
			}
		}
		avg = (double)sum/10;
		System.out.println(avg+ " " + max + " " +min);
	}

}
