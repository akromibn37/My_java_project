import java.util.Scanner;

public class class_129_1 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student []s = new Student[10];		
		Scanner sc =new Scanner(System.in);
		for(int i =0;i<s.length;i++){
			s[i] = new Student();
			System.out.print("Input name :");
			s[i].name=sc.nextLine();
			System.out.print("Input surname : ");
			s[i].surname = sc.nextLine();
			System.out.println("Input score : ");
			s[i].score =sc.nextInt();
			sc.nextLine();//protect error because nextint not have to goto nextline
		}
		Student max ;
		max =s[0];
		for(int i =0;i<s.length;i++){
			if(max.score>s[i].score){
				max = s[i];
			}
		}
		System.out.println(max.name + " " + max.surname + " " + max.score);
	}

}
