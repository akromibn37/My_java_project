
public class Ex3_262_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis(); 
		for(int i=100000;i>0;i--){
			int count =0;
			for(int j=1;j<=i;j++){
				if(i%j==0){
					count++;
				}
			}
			if(count ==2){
				System.out.println(i);
				//break;
			}
		}
		long stop = System.currentTimeMillis();
		System.out.println(stop-start);
	}

}
