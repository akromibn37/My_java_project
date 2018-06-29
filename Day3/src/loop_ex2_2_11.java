import java.util.Scanner;

public class loop_ex2_2_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int count=0;
		int n;
		Scanner sc=new Scanner(System.in);		
		double avg;
		for(;;){
			System.out.println("input positive");
			n = sc.nextInt();
			if(n<0){
				System.out.println("Error ,Fill again");
				continue;
			}
			else{
				if(n==0){
					if(count==0){
						System.out.print("No Avg");
						
					}
					else{
						avg=(double)sum/count;
						System.out.print(avg);
					}
					break;
				}
				else{
					sum+=n;
					count++;
							
				}
			}
		}
		
	
	}

}
