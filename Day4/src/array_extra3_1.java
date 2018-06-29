import java.util.Scanner;

public class array_extra3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] x = new int[10];
		for(int i = 0;i<x.length;i++){
			x[i]=sc.nextInt();
		}
		int count = 0;
		for(int j=0;j<x.length;j++){
			if(x[j]>=10){
				count++;
			}
		}
		System.out.println(count);
	}

}
