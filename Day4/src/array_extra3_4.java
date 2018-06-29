import java.util.Arrays;
import java.util.Scanner;

public class array_extra3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] x = new int[10];
		for(int i = 0;i<x.length;i++){
			x[i]=sc.nextInt();
		}		
		int index = -1;
		System.out.println("input v : ");
		int v =sc.nextInt();
		
		for(int j=0;j<x.length;j++){
			if(x[j]==v){
				index = j;
				break;
			}
		}
		if(index != -1){			
		
			for(int i =index;i<x.length-1;i++){
				x[i]=x[i+1];
			}
			x[x.length-1]=0;				
			System.out.println(Arrays.toString(x));
		}
		
	}

}
