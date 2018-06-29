
public class Testcat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cat c = new cat();
		cat d = new cat();
		c.x = 10;
		c.y = 20;
		d.x = 15;
		d.y = 26;
		c.z = 100; //c is object should not annouce like this.
		cat.z = 200; //should use like this.
		
		System.out.println(c);
		System.out.println(d);
		c.say();
		d.say();
		
		c.xxx();
		d.xxx();
		cat.xxx();
		
		System.out.println(c.THIS_IS_CONST);
		System.out.println(cat.THSI_IS_CONT_STATIC);
	}

}
