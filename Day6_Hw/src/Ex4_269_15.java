import java.util.Arrays;
import java.util.Scanner;

public class Ex4_269_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a= new int[10];
		Scanner sc = new Scanner(System.in);
		int y;
		for(int i =0;i<a.length;i++)
		{
			System.out.print("Input "+(i+1) + " : ");
			a[i] = sc.nextInt();
		}
		for(int i = 0;i<a.length;i++)
		{
			for(int j=0;j<a.length-1;j++)
			{
				if(a[j]>a[j+1])
				{
					y = a[j];
					a[j] = a[j+1];
					a[j+1] = y;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
