import java.util.Scanner;

public class if_else_2_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		double c;
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextDouble();
		if(c==1){
			c=a+b;
			System.out.println("answer a+b = "+(int)c);
		}
		else if(c==2){
			c=a-b;
			System.out.println("answer a-b = "+(int)c);
		}
		else if(c==3){
			c=a*b;
			System.out.println("answer a*b = "+(int)c);
		}
		else if(c==4){
			c=a/b;
			System.out.println("answer a/b = "+ c);
		}
		else{
			System.out.println("Please input ''c' only 1-4: Program closed ");
		}
	}

}
