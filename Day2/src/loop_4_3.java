import java.util.Scanner;

public class loop_4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner dc = new Scanner(System.in);
		int a, b;
		System.out.print("Please input two numbers : ");
		a = dc.nextInt();
		b = dc.nextInt();
		int k;
		if(a>b){
			k=a;
		}
		else{
			k=b;
		}
		while (true) {
			if(k%a==0 && k%b==0){
			break;}
			k++;
		}
		System.out.println(k);
	}

}
