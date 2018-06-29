import java.util.Scanner;

public class while_method_257_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n, sumplus = 0,summinus=0;
		double avgplus,avgminus;
		int i = 0;
		int j =0;
		while (true) {
			System.out.print("input n : ");
			n = sc.nextInt();

			if (n != 0) {
				if(n>0){
				sumplus += n;
				i++;}
				else{
					summinus +=n;
					j++;
				}
			} else {
				break;
			}
		}
		avgplus = (double) sumplus / i;
		avgminus = (double) summinus/j;
		System.out.println("avgplus = " + avgplus + " sumplus = " + sumplus);
		System.out.println("avgminus = " + avgminus + " summinus = " + summinus);
	}
}
