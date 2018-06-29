
public class Problem3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double y = 13195;
		double prime = 0;
		for (int i = 0; i < y-1; i++) {
			double x = y-i;
			System.out.println(x);
			boolean t = isPrime(x);
			System.out.println(t);
			if(t){prime = x; System.out.println("change prime " + prime);}

		}
		System.out.println(prime);

	}
	
	public static boolean isPrime(double num)
	{
		System.out.println("isprime : " + num);
		for(int i=2;i<=(int)Math.sqrt(num)+1;i++){ //loops through 2 to sqrt(num). All you need to check- efficient
			if(num%i==0){ //if a divisor is found, its not prime. returns false
				return(false);
		    }
		}
		return true;
	}

}
