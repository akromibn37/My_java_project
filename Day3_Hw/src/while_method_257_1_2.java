
public class while_method_257_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		int sum=0;
		int i =1;
		while (i <= n) {
			if(i%2==0){
				System.out.println(i);
			}
			sum+=i;
			i++;
		}
		System.out.println(sum);
	}

}
