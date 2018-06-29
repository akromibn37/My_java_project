
public class loop_2_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int n = 10;
		while (i <= n) {
			int j = 1;
			int count = 0;
			int x = i+i-1;
			while (j <= n + i - 1) {				
				if (j >= n - i + 1 && j <= n + i - 1) {
					if (i%2 == 0) {
						count++;
						System.out.print(count);
					} else {			
						
						System.out.print(x);
						x--;
					}
				} else {
					System.out.print("-");
				}
				j++;
			}
			count=0;
			System.out.println();
			i++;
		}
	}

}
