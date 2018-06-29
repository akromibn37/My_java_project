import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ex3_262_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal ans = new BigDecimal(Math.PI);
		ans = ans.setScale(6, RoundingMode.DOWN);
		String l = ans.toString();
		Double r = Double.parseDouble(l);
		
		double sum=0;
		double pie;		
		double i =1;
		int j =1;
		while(true){
			if(j%2==0)
			{
				sum =sum - (1/i);						
			}
			else
			{
				sum =sum+ (1/i);								
			}
			pie = sum*4;
			BigDecimal bd = new BigDecimal(pie);
			bd = bd.setScale(6, RoundingMode.UP);
			String z = bd.toString();
			double k = Double.parseDouble(z);
			System.out.println("sum = "+ bd);
			System.out.println("ans = "+ ans);
			System.out.println();
			
			if(k!=r)
			{
				i+=2;
				j++;				
			}
			else 
			{
				System.out.println("count = "+j);
				break;
			}			
		}
	}
}
