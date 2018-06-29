import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ex3_260_20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		Random rand = new Random();
		
		int []x = new int[100];
		for(int i=0;i<x.length;i++)
		{
			x[i] = rand.nextInt(n);
		}
		System.out.println(Arrays.toString(x));
	}

}
