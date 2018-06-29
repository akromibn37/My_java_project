
public class xplush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		x = 100;
		while (x >= 1) {
			if (x % 3 == 0 || x%5==0) {
				if((x % 3 == 0 && x%5!=0)||(x % 3 != 0 && x%5==0)){
					System.out.println(x);
				}
			}
			x--;
		}
	}

}
