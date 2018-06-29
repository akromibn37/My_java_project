import java.util.Scanner;

public class Ex4_267_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,d;
		int sum,min;
		Scanner sc = new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		min =a;
		if(b<min){
			min = b;
		}
		if(c<min){
			min =c;
		}
		if(d<min){
			min =d;
		}
		sum = a+b+c+d;
		int pay =sum -min;
		System.out.println(min);
		System.out.println("sum all = "+sum +" You have to pay = "+pay);
				
		
	}

}
