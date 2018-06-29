
public class loop_ex2_5_coza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub				
		for(int i=0;i<=110;i++){
			if(i%3==0 && i%5==0){
				System.out.print("CozaLoza\t");
			}
			else{
				if(i%3==0){
					System.out.print("coza\t");
				}
				else if(i%5==0){
					System.out.print("loza\t");
				}
				else if(i%7==0){
					System.out.print("woza\t");
				}
				else{
					System.out.print(i+"\t");
				}
			}
			if(i%11==0){
				System.out.println();
			}			
		
		}
	}

}
