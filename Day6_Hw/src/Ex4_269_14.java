import java.util.Arrays;
import java.util.Scanner;

public class Ex4_269_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a = new int[5];
		Scanner sc = new Scanner(System.in);
		int []max = new int[20];
		int amount = 0;
		
		
		for(int i =0;i<a.length;i++)
		{
			System.out.print("Input "+(i+1) + " : ");
			a[i] = sc.nextInt();
		}
		for(int i=0;i<a.length;i++)
		{			
			boolean same = false;
			
			for(int j=0;j<a.length;j++)
			{
				if((a[i] == a[j]) && i!=j)
				{					
					same = true;
					break;
				}
			}
			if(same)
			{
				boolean checkmax = false; 
				for(int k = 0;k<max.length;k++)
				{
					if(a[i]==max[k])
					{
						checkmax = true;
						break;
						
					}
				}
				if(!checkmax)
				{
					max[amount] = a[i];
					amount++;
				}
			}
			
		}
		System.out.println(Arrays.toString(a));
		System.out.println("same = "+amount);
		System.out.println(Arrays.toString(max));
		sc.close();
	}

}
