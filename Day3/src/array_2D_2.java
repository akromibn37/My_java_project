import java.util.Arrays;
import java.util.Random;

public class array_2D_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]x = new int[4][4];
		int [][]y = new int[4][4];
		int [][]z = new int[x.length][y[0].length];
		filldata(x);
		System.out.println();
		filldata(y);
		System.out.println();
		multiplymatrix(x,y,z);	
		//System.out.println(Arrays.toString(z[0]));
		//System.out.println(Arrays.toString(z[1]));
	}
	public static void filldata(int [][]x){
		Random rand = new Random();
		for(int i =0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++){
				x[i][j] = rand.nextInt(10);
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void multiplymatrix(int [][]x,int [][]y,int [][]z){
		for (int i = 0; i < x.length; i++) { // xRow
            for (int j = 0; j < y[0].length; j++) { // yColumn
                for (int k = 0; k < x[0].length; k++) { // xColumn
                    z[i][j] += x[i][k] * y[k][j];
                }
                System.out.print(z[i][j]+ " ");
            }
            System.out.println();
        }
	}

}
