import java.util.Scanner;

public class Ex4_269_8 {
	public static void main(String[] args) {
		Data[] d = new Data[2];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < d.length; i++) {
			d[i] = new Data();
			System.out.print("Input name : ");
			d[i].name = sc.nextLine();
			System.out.print("Input surname : ");
			d[i].surname = sc.nextLine();
			System.out.print("Input sex : ");
			d[i].sex = sc.nextLine();
			System.out.print("Input phonenumber : ");
			d[i].phonenumber = sc.nextLine();
			System.out.print("Input email : ");
			d[i].email = sc.nextLine();
		}
		System.out.print("Search name(Input name) : ");
		String a = sc.nextLine();		
		Data y = new Data();
		y = y.search(a, d);
		
		System.out.println(y.name + "," + y.surname + "," + y.sex + "," + y.phonenumber + "," + y.email);

	}

}
