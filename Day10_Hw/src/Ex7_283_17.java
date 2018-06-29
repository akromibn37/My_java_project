import java.util.Arrays;

public class Ex7_283_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] s = new int[][]{{9,6,3,1,7,4,2,5,8},{1,7,8,3,2,5,6,4,9},{2,5,4,6,8,9,7,3,1},{8,2,1,4,3,7,5,9,6},{4,9,6,8,5,2,3,1,7},{7,3,5,9,6,1,8,2,4},{5,8,9,7,1,3,4,6,2},{3,1,7,2,4,6,9,8,5},{6,4,2,5,9,8,1,7,3}};
		boolean isSudoku = isSudoku(s);
		System.out.println(isSudoku);
//		System.out.println(s.length + " " + s[0].length);
//		System.out.println(Arrays.toString(s[0]));
//		System.out.println(Arrays.toString(s[1]));
//		System.out.println(Arrays.toString(s[2]));
//		System.out.println(Arrays.toString(s[3]));
//		System.out.println(Arrays.toString(s[4]));
//		System.out.println(Arrays.toString(s[5]));
//		System.out.println(Arrays.toString(s[6]));
//		System.out.println(Arrays.toString(s[7]));
//		System.out.println(Arrays.toString(s[8]));
	}

	public static boolean isSudoku(int[][] a) {
		int row = 0;
		int column = 0;
		int brow = 0;
		int bcolumn = 0;
		boolean isSudoku = true;

		System.out.println("checkrow");
		while (row < 9) {
			
			for (int i = 0; i < a.length; i++) 
			{
				for (int j = i + 1; j < a[0].length; j++) 
				{
//					System.out.println(i + " " + j);
					if (a[row][i] == a[row][j] && (i!=j)) 
					{
						System.out.println(row + " ," +i +" = " + a[row][i] + " ; "+ row + " ," +j +" = " + a[row][j]);
						System.out.println("in");
						isSudoku = false;
						break;
					}
				}
			}
			row++;
		}		

		System.out.println("checkcolumn");
		while(column < 9)
		{
			for (int i = 0; i < a.length ; i++) 
			{
				for (int j = i + 1; j < a[0].length ; j++) 
				{
//					System.out.println(i + " " + j);
					if (a[i][column] == a[j][column] && i!=j) 
					{
						System.out.println("in");
						isSudoku = false;
						break;
					}
				}
			}
			column++;
		}
		
		System.out.println("checkbox");
		while(brow<7)
		{
			for (int i = brow; i < brow+3 ; i++) 
			{
				for (int j = bcolumn; j < bcolumn+3; j++) 
				{
					for(int k = brow;k<brow+3;k++)
					{
						for(int l = bcolumn;l<bcolumn+3;l++)
						{
							if (a[i][j] == a[k][l] && (i!=k || j!=l)) 
							{
								System.out.println("in");
								isSudoku = false;
								break;
							}
						}
					}
				}
			}			
			if(bcolumn ==6)
			{
				bcolumn = 0;
				brow += 3; 
			}
			else
			{
				bcolumn+=3;
			}
		}
		return isSudoku;
	}

}
