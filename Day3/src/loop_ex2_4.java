
public class loop_ex2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double A = 50e6;
		double B = 70e6;
		double y;
		/*while(true){
			A=A*1.03;
			B=B*1.02;
			y++;
			System.out.println("Year "+y+" A = "+A+"B = "+B);
			if(A>=B){
				break;
			}			
		}*/
		y=Math.log(A/B)/Math.log(1.02/1.03);
		y=Math.ceil(y);
		System.out.println("It's took "+y+" years" );
	}

}
