
public class if_else_1_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 500;
		int count = 0;
		while(x<20000){
			count++;
			x=x*1.03;
			System.out.println("He have "+x+ "bath in " + count + " years");
		}
		System.out.println("Deang have to wait for "+count+" years");
	}

}
