import java.util.Random;

public class Ex3_259_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] x = new int[2][3];
		filldata(x);
		int sumproduct1 = caldata(x,1,0);
		int sumproduct2 = caldata(x,1,1);
		int summonth1 = caldata(x,2,0);
		int summonth2 = caldata(x,2,1);
		int summonth3 = caldata(x,2,2);
		int sumall = sumall(x);
		System.out.println(sumproduct1 +" " + sumproduct2);
		System.out.println(summonth1 +" " + summonth2 + " " + summonth3);
		System.out.println(sumall);

	}

	public static void filldata(int[][] x) {
		Random rand = new Random();
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				x[i][j] = rand.nextInt(100);
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int caldata(int [][]x,int y,int z)
	{
		//y=1 -> cal each product income
		//y=2 -> cal month income
		int sum =0;
		
		if(y==1)
		{
			for(int j = 0;j<x[0].length;j++)
			{
				
					sum += x[z][j];
				}
		}
		else
		{
			for(int i = 0;i<x.length;i++){
					sum += x[i][z];
			}
		}
		return sum;
	}
	
	public static int sumall(int[][] x) {
		int sum=0;
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[0].length; j++) {
				sum += x[i][j];
			}
		}
		return sum;
	}

}
