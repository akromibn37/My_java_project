import java.util.Scanner;

public class if_else_flow_chart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		System.out.print("Please input a,b,c : ");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		if(a>13){
			if(b!=6){
				System.out.println("A");
			}
			else{
				if(c<=7){
					System.out.println("B");
				}
				else{
					System.out.println("C");
				}
			}
		}
		else{
			if(b<=16){
				System.out.println("D");
			}
			else{
				if(c>6){
					System.out.println("E");
				}
				else{
					System.out.println("F");
				}
			}
		}
	}

}
