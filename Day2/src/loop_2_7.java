
public class loop_2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		int n = 9;
		while (i <= n) {
			int j = 1;
			int countl = 0;
			int countr = i;
			while (j <= n + i-1) {
				
				if (j >= n - i + 1 && j <= n + i - 1) {
					if(j==n){
					System.out.print(i);}
					else{
						if(j<n){
							countl++;
						System.out.print(countl);}
						else{
							countr--;							
							System.out.print(countr);
						}
					}
				} else {
					System.out.print("-");
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
