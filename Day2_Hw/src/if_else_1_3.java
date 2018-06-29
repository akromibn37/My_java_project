import java.util.Scanner;

public class if_else_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int m, a, b, c, y;
		System.out.print("Please input a,b,c,m : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		m = sc.nextInt();
		if(m>5){
			y=a*m*2 + b*m+c;
		}
		else if(m==5){
			y=a*m*2 + b*m-c;
		}
		else{
			y=a*m*2 + b*m;
		}
		System.out.println(y);
	}

}
