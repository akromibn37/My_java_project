
public class Ex7_286_12_testPiggy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PiggyBank a = new PiggyBank();
		a.add1(10);
		a.add2(10);
		a.add5(1);
		a.add10(1);
		System.out.println(a);
		System.out.println(a.getTotal());
		a.clear();
		System.out.println(a);
	}

}
