import java.util.Arrays;

class threadtest implements Runnable{
	private Thread t;
	private String threadname;
	private int core;
	private double stime;
//	private int[][] a = {{1,2,3,4,5,6,7,8},{5,6,7,8,9,10,11,12},{9,10,11,12,13,14,15,16},{13,14,15,16,17,18,19,20},{1,2,3,4,5,6,7,8},{5,6,7,8,9,10,11,12},{9,10,11,12,13,14,15,16},{13,14,15,16,17,18,19,20}};
//	private int[][] b = {{1,2,3,4,5,6,7,8},{5,6,7,8,9,10,11,12},{9,10,11,12,13,14,15,16},{13,14,15,16,17,18,19,20},{1,2,3,4,5,6,7,8},{5,6,7,8,9,10,11,12},{9,10,11,12,13,14,15,16},{13,14,15,16,17,18,19,20}};
//	private int[][] a = {{1,2,3,4},{4,5,6,7},{7,8,9,10},{10,11,12,13}}; 
//	private int[][] b = {{1,2,3,4},{4,5,6,7},{7,8,9,10},{10,11,12,13}}; 
	private int[] a = new int[20];

	threadtest(int x,String name,double starttime)
	{
		threadname = name;
		core =x;
		stime = starttime;
//		System.out.println("Creating :" + threadname);
	}
	public double multiply()
	{
		try {
			for(int i = core-1;i<20;i+=4)
			{
				a[i] = i;	
				System.out.println("core  " + core +" : " + a[i]);
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
		System.out.println(Arrays.toString(a));
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
public class multicore_image {
	public static void main(String[] args)
	{
		double starttime = System.currentTimeMillis();
		System.out.println("Starttime : " + starttime);
		threadtest r1 = new threadtest(1,"core1",starttime);
		r1.start();
//		threadtest r2 = new threadtest(2,"core1",starttime);
//		r2.start();
//		threadtest r3 = new threadtest(3,"core1",starttime);
//		r3.start();
//		threadtest r4 = new threadtest(4,"core1",starttime);
//		r4.start();
	}
}
