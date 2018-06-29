import java.util.Random;

public class while_method_257_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int i = 0;
		while (i < 100) {
			int x = rand.nextInt(100);
			if (x % 2 != 0) {
				System.out.print(x + " ");
				if (i == 19) {
					System.out.println();
				} else if (i == 39) {
					System.out.println();
				} else if (i == 59) {
					System.out.println();
				} else if (i == 79) {
					System.out.println();
				} else if (i == 99) {
					System.out.println();
				}
				
			} 
			else{
				continue;
			}

			i++;
		}
	}

}
