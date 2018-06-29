import java.util.Scanner;

public class while_method_257_3_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a,b,c;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		int suma,sumb,sumc;
		suma=separate(a);
		sumb=separate(b);
		sumc=separate(c);
		System.out.println("sum of a = "+suma+", sum of b = "+sumb+", sum of c = "+sumc);
	}
	public static int separate(int a){
		int sum=0;
		int a1,a2,a3;
		a1=a/100;
		a2=(a-(a1*100))/10;
		a3=a-(a1*100)-(a2*10);
		sum = a1+a2+a3;
		return sum;
	}

}
