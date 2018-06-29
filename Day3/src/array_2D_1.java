import java.util.Scanner;

public class array_2D_1 {
	public static void main(String[] args) {
		int [][] A =new int[3][3];
		int [][] B =new int[3][3];
		int [][] C =new int[3][3];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				A[i][j]=sc.nextInt();
			}
			
		}
		for(int i=0;i<B.length;i++){
			for(int j=0;j<B[0].length;j++){
				B[i][j]=sc.nextInt();
			}
			
		}
		for(int i=0;i<A.length;i++){
			for(int j=0;j<A[0].length;j++){
				C[i][j]=A[i][j]+B[i][j];
				System.out.print(C[i][j]+" ");
			}
			System.out.println();			
		}
		
	}
}
