import java.util.Scanner;

public class page_130_1_useclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student []s = new Student[2];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < s.length; i++) {
			s[i] =new Student();
			System.out.println("Please input name,surname,score : ");
			s[i].name = sc.nextLine();
			s[i].surname = sc.nextLine();
			s[i].score = sc.nextInt();
			sc.nextLine();
		}
		Student max = new Student();
		max.score = Integer.MIN_VALUE;		
		for (int i = 0; i < s.length; i++) {
			if (s[i].score > max.score) {
				max = s[i];
			}
		}
		System.out.println("The top student is "+max.name+" "+max.surname);

	}

}
