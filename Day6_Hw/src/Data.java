
public class Data {

	public String name;
	public String surname;
	public String sex;
	public String phonenumber;
	public String email;

	public Data search(String a, Data[] d) {
		Data y = new Data();
		y.name = "No match";
		System.out.println(a);
		
		for (int i = 0; i < d.length; i++) {
			if (d[i].name.equals(a)) {
				y = d[i];
				System.out.println("come in");
			}
			else{
				System.out.println("no");			
			}

		}		
		return y;

	}

}
