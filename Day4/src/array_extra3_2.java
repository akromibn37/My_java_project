import java.util.Scanner;

public class array_extra3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] x = new int[10];
		for(int i = 0;i<x.length;i++){
			x[i]=sc.nextInt();
		}
		int count = 0;
		System.out.println("Input V : ");
		int v =sc.nextInt();
		for(int j=0;j<x.length;j++){
			if(x[j]==v){
				count++;
				break;
			}
		}
		if(count == 0){System.out.println("is not");}
		else{
			System.out.println("is in");
		}
	}

}
