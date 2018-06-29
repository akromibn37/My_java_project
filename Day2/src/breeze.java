import java.util.Scanner;

public class breeze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input weight A and price A : ");
		double wa,pa,wb,pb,a,b;
		wa = sc.nextDouble();
		pa = sc.nextDouble();
		System.out.println("Weight A : "+ wa);
		System.out.println("Price A : "+ pa);
		System.out.print("Input weight B and price B : ");
		wb = sc.nextDouble();
		pb = sc.nextDouble();
		System.out.println("Weight B : "+ wb);
		System.out.println("Price B : "+ pb);
		a=wa/pa;
		b=wb/pb;
		if(b>a){
			System.out.println("A is lower than B");
		}
		else if(a==b){
			System.out.println("A is equal B");
		}
		else{
			System.out.println("B is Lower than A");
		}
	}

}
