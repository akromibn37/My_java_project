import java.util.Arrays;

public class Ex7_282_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []x = new int[]{32,23,11,55,18,2,1,37};
		System.out.println(Arrays.toString(x));
		bubbleSort(x);
		System.out.println(Arrays.toString(x));
	}
	public static void bubbleSort(int []d)
	{
		int y;
		for(int i = 0;i<d.length-1;i++)
		{
			for(int j = i+1;j<d.length;j++)
			{
				if(d[i]>d[j])
				{
					y = d[i];
					d[i] = d[j];
					d[j] = y;
				}
			}
		}
	}

}
