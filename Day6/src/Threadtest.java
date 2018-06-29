
public class Threadtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new Runnable(){
			public void run (){
				while(true){
					try {
						Thread.sleep(200);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("a");
				}
			}
		});
		t.start();
		Thread t2 =new Thread(new Runnable(){
			public void run(){
				while(true){
					try{
						Thread.sleep(400);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					System.out.println("b");
				}
			}
		});
		t2.start();
	}

}
