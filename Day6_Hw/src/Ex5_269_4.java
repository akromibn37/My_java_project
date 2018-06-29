import java.util.Scanner;

public class Ex5_269_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number : ");
		int x = sc.nextInt();
		sc.nextLine();
		int sum = x;
		int count = 1;
		String y;
		System.out.println("Do you want to fill more number??(Y/N)");
		y = sc.nextLine();
		while(y.equals("Y"))
		{
			System.out.print("Input number : ");
			x = sc.nextInt();
			sc.nextLine();
			sum+=x;
			count++;
			System.out.println("Do you want to fill more number??(Y/N)");
			y = sc.nextLine();			
		}
		double avg = (double)sum/count;
		System.out.println(sum);
		System.out.println(avg);
	}

}
