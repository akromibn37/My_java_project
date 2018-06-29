import java.util.Arrays;

public class Ex8_286_13_testSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSet a= new IntSet(5);		
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(10);
		System.out.println("a = " + Arrays.toString(a.a));
		IntSet b =new IntSet(3);
		b.add(3);
		b.add(4);
		b.add(5);
		System.out.println("b =" + Arrays.toString(b.a));
		IntSet c = a.union(b);
		System.out.println("a union b= " + Arrays.toString(c.a));
		IntSet d = a.intersection(b);
		System.out.println("a intersection b =" + Arrays.toString(d.a));
	}

}
