import java.util.Scanner;

public class loop_ex2_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,max=0,min=0,mid=0,diff1,diff2;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input a,b,c : ");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		if(a>b && a>c){
			max=a;
			if(b>c){
				mid=b;
				min=c;
			}
			else{mid=c;min=b;}
		}
		else if(b>a && b>c){
			max=b;
			if(a>c){
				mid=a;
				min=c;
			}else{mid=c;min=a;}
		}
		else if(c>a && c>b){
			max = c;
			if(a>b){
				mid=a;
				min=b;
			}else{mid=b;min=a;}
		}
		diff1=mid-min-1;
		diff2=max-mid-1;
		
		if(diff1>diff2){
			System.out.println(diff1);
		}
		else{
			System.out.println(diff2);
		}
	}

}
