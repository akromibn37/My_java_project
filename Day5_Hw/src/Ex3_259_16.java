import java.util.Random;

public class Ex3_259_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int []x = new int[100];
		for(int i =0;i<100;i++)
		{
			x[i] = rand.nextInt(100);			
			System.out.print(x[i] + " ");
			if((i+1)%25==0)System.out.println();
		}
		
	}

}
