import java.util.Scanner;

public class Super_Ex4_58_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] x = new char[][] { { 'a', 'b', 'c', 'd' }, { 'e', 'f', 'g', 'h' }, { 'i', 'j', 'k', 'l' },
				{ 'm', 'n', 'o', 'p' } };
		print(x);
		
		Scanner sc = new Scanner(System.in);
		while (true) 
		{
			/*int row = sc.nextInt();
			char a = sc.next().charAt(0);
			char y;
			for(int i = 0;i<=3;i++){
				if(a == 'u' || a== 'd')
				{
					y = x[i][row];
					x[3-i][row] = x[i][row];
					x[i][row] = y;
				}
			}*/
			System.out.println("input (1:3) and (l,r,u,d)");
			int n = sc.nextInt();sc.nextLine();
			if(n==-1){break;}
			String c =sc.nextLine();
			if(c.charAt(0) == 'l')
			{
				char t =x [n][0];
				for(int i=0;i<x[0].length-1;i++)
				{
					x[n][i] = x[n][i+1];
				}
				x[n][x[0].length-1]=t;
				
			}
			else if(c.charAt(0)=='r'){
				char t =x[n][x[0].length-1];
				for(int i = x[0].length-1;i>0;i--)
				{
					x[n][i] = x[n][i-1];
				}
				x[n][0] = t;
			}
			else if(c.charAt(0)=='d'){
				char t =x[x[0].length-1][n];
				for(int i = x.length-1;i>0;i--)
				{
					x[i][n] = x[i-1][n];
				}
				x[0][n] = t;
			}
			else {
				char t =x[0][n];
				for(int i = x[0].length-1;i>0;i--)
				{
					x[i][n] = x[i+1][n];
				}
				x[0][x[0].length-1] = t;
			}
			print(x);
		}

	}
	public static void print(char [][]x)
	{
		for(int i=0;i<x.length;i++)
		{
			for(int j =0;j<x[0].length;j++)
			{
				System.out.print(x[i][j] + " ");
			}
			System.out.println();
		}
	}

}
