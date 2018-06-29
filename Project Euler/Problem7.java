
public class Problem7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 6;
		int num = 13;
		while(i<10001)
		{
			num++;
			System.out.println(num);
			if(isPrime(num)){i++;}
		}
		System.out.println(num);
	}
	public static boolean isPrime(int num)
	{
		for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ //loops through 2 to sqrt(num). All you need to check- efficient
		      if(num%i==0){ //if a divisor is found, its not prime. returns false
		        return(false);
		      }
		    }
		return true;
	}

}
