import java.util.Arrays;
import java.util.Scanner;

public class Ex4_267_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int []x=new int[10];
		int y;
		
		for(int i =0;i<10;i++){
			x[i]=sc.nextInt();			
		}
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x.length-1;j++){
				if(x[j]>x[j+1]){
					y=x[j];
					x[j]=x[j+1];
					x[j+1]=y;
				}
			}
		}
		System.out.println(Arrays.toString(x));
		System.out.println("max number is " +x[x.length-1]);
		System.out.println("max2 number is " +x[x.length-2]);
	}	

}
