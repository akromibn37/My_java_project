
public class loop_1_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 1;
		while (i <= 1000) {
			if (i % 3 == 0 && i % 5 == 0 && i!=105) {
				System.out.println(i);
			} else if (i % 3 == 0 && i % 7 == 0  && i!=105) {
				System.out.println(i);
			} else if (i % 5 == 0 && i % 7 == 0  && i!=105) {
				System.out.println(i);
			}
			i++;
		}
	}

}
