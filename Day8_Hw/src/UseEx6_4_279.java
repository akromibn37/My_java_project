import java.util.Scanner;

public class UseEx6_4_279 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		Scanner sc = new Scanner(System.in);
		int sum,sub,mul,div,mod,a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		Ex6_4_279 k = new Ex6_4_279(a,b);
		sum = k.sum(k);
		sub = k.sub(k);
		mul = k.mul(k);
		div = k.div(k);
		mod = k.mod(k);
		System.out.println("sum = "+sum);
		System.out.println("sub = "+sub);
		System.out.println("mul = "+mul);
		System.out.println("div = "+div);
		System.out.println("mod = "+mod);
	}

}
