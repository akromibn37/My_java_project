import java.util.Scanner;

public class Ex4_267_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int x,max;
		max = Integer.MIN_VALUE;
		for(int i =0;i<10;i++){
			x=sc.nextInt();
			if(x>max){
				max =x;
			}
		}
		System.out.println("max number is " +max);
	}

}
