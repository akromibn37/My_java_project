import java.util.Arrays;

class threadtet implements Runnable{
	private Thread t;
	private String threadname;
	private int core;
	private double stime;
	private int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
	private int[][]y = new int[4][4];
	int[] k ={0,1,2,3};

	threadtet(int x,String name,double starttime)
	{
		threadname = name;
		core =x;
		stime = starttime;
//		System.out.println("Creating :" + threadname);
	}
	public double multiply()
	{
		try {
			for(int i = 0;i<4;i++)
			{
				for(int j = core-1; j<4;j+=4)
				{
					y[j][i] = a[k[core-1]] + a[k[core-1]+1];	
					k[core-1]+=4;
				}
				
				Thread.sleep(10);	
			}			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return System.currentTimeMillis();
	}
	
	public void run() {
		// TODO Auto-generated method stub
//		System.out.println("running" + threadname);
		double time = multiply();
		double totaltime = time - stime;
//		System.out.println(Arrays.toString(a));
		System.out.println(threadname + " : " + Arrays.toString(y[core-1]));
//		System.out.println(threadname + " : " + Arrays.toString(y[1]));	
//		System.out.println(threadname + " : " + Arrays.toString(y[2]));	
//		System.out.println(threadname + " : " + Arrays.toString(y[3]));	
		System.out.println("totaltime "+ core +" : " + totaltime);
		
	}
	public void start()
	{
//		System.out.println("Starting " + threadname);
		if (t == null) {
	         t = new Thread (this, threadname);
	         t.start ();
	    }
	}
	
}
public class multicore_fibo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double starttime = System.currentTimeMillis();
		System.out.println("Starttime : " + starttime);
		threadtet r1 = new threadtet(1,"core1",starttime);
		r1.start();
		threadtet r2 = new threadtet(2,"core2",starttime);
		r2.start();
		threadtet r3 = new threadtet(3,"core3",starttime);
		r3.start();
		threadtet r4 = new threadtet(4,"core4",starttime);
		r4.start();
	}

}
