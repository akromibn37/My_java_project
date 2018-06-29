import java.util.Scanner;

public class array_extra3_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] x = new int[10];
		for(int i = 0;i<x.length;i++){
			x[i]=sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int max_index = 0;
		
		for(int j=0;j<x.length;j++){
			if(x[j]>max){
				max = x[j];
				max_index = j;
			}
		}
		System.out.println("max = "+ max + " "+max_index);
	}

}
