import java.util.Arrays;

class threadsort implements Runnable
{
	private Thread t;
	private String threadname;
	private int core;
	private int[] numbers = {3,2,4,1,6,7,5,8,10,9,12,17,15,16,13,11,14,20,18,19};
	private int number;
	
	threadsort(int x,String name)
	{
		threadname = name;
		core =x;
//		System.out.println("Creating :" + threadname);
	}
	private int[] quicksort(int low,int high)
	{
		int i = low; int j = high;
		int pivot = numbers[low + (high-low)/2];
		while(i<=j)
		{
			while(numbers[i]<pivot)
			{
				i++;
			}
			while(numbers[j]>pivot)
			{
				j--;
			}
			
			if(i<=j)
			{
				exchange(i,j);
				i++;
				j--;
			}
		}
		if(low<j) quicksort(low,j);
		if(i<high) quicksort(i,high);
		
		return numbers;
	}
	private void exchange(int i , int j)
	{
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int result[];
		number = numbers.length;
		result = quicksort(0,number-1);
		System.out.println(Arrays.toString(result));
	}
	public void start()
	{
		System.out.println("Starting " + threadname);
		if (t == null) {
	         t = new Thread (this, threadname);
	         t.start ();
	    }
	}
	
}
public class multicore_quicksort {
	public static void main(String [] args)
	{		
		threadsort r1 = new threadsort(0,"core1");
		r1.start();
//		threadsort r2 = new threadsort(1,"core2");
//		r2.start();	
//		threadsort r3 = new threadsort(2,"core3");
//		r3.start();	
//		threadsort r4 = new threadsort(3,"core4");
//		r4.start();	
	}
}
