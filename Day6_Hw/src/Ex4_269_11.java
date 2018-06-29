import java.util.Scanner;

public class Ex4_269_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] a = new int[2][2];
		int[][] b = new int[2][2];
		int[][] c = new int[2][2];
		int[][] d = new int[2][2];
		System.out.println(" a :");
		filldata(a);
		System.out.println(" b :");
		filldata(b);
		c = add(a,b);
		d = multiply(a,b);
		printdata(a);
		System.out.println();
		printdata(b);
		System.out.println();
		printdata(c);
		System.out.println();
		printdata(d);
		System.out.println();		

	}

	public static void filldata(int[][] a) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print("input " + (i + 1) + (j + 1) + " : ");				
				a[i][j] = sc.nextInt();
			}
		}
	}
	public static int[][] add(int [][]a,int [][]b)
	{
		int [][]c = new int [a[0].length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				c[i][j] = a[i][j] + b[i][j];				
			}
		}
		return c;
	}
	public static int[][] multiply(int [][]a,int [][]b)
	{
		int [][]c = new int [a[0].length][b.length]; 
		for (int i = 0; i < a.length; i++) { // aRow
            for (int j = 0; j < b.length; j++) { // bColumn
                for (int k = 0; k < a.length; k++) { // aColumn
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
		return c;
		
	}
	public static void printdata(int[][] a) {		
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {							
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

}
