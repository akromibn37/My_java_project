import java.util.Scanner;

public class if_else_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		double b,c;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input 1-3 : ");
		a = sc.nextInt();
		
		if(a==1){
			System.out.print("input 2 decimal numbers :");
			b=sc.nextDouble();
			c=sc.nextDouble();
			System.out.println(b+" + "+c +" = " + (b+c));
		}
		else if(a==2){
			System.out.print("input 2 decimal numbers :");
			b=sc.nextDouble();
			c=sc.nextDouble();
			System.out.println(b+" * "+c +" = " + (b*c));
		}
		else if(a==3){
			System.out.print("input 2 decimal numbers :");
			b=sc.nextDouble();
			c=sc.nextDouble();
			System.out.println(b+" / "+c +" = " + (b/c));
		}
		else{
			System.out.println("Please input only 1-3.");
		}
	}

}
