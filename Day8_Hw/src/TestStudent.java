import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mainStudent []s = new mainStudent[3];
		Scanner sc = new Scanner(System.in);
		int x =0;
		String ID,name,surname;
		int point;
		for(int i = 0;i<s.length;i++)
		{
			
			System.out.print("Input ID : ");
			ID = sc.nextLine();
			System.out.print("Input Name : ");
			name = sc.nextLine();
			System.out.print("Input Surname : ");
			surname = sc.nextLine();
			System.out.print("Input Points : ");
			point = sc.nextInt();
			s[i] = new mainStudent(ID,name,surname,point);
			s[i].grade = s[i].Grade(s[i].point);
			sc.nextLine();	
			System.out.println();
		}
		for(int i =0;i<s.length;i++)
		{
			s[i].Print(s[i]);
		}
		String StuMax = s[x].max(s);
		String StuMin = s[x].min(s);
		double avg = s[x].avg(s);
		System.out.println();
		System.out.println("Student that get Max Score is "+StuMax);
		System.out.println("Student that get Min Score is "+StuMin);
		System.out.println();
		System.out.println("Avg Score is " + avg);
		System.out.println("Student that under average are : ");
		System.out.println();
		for(int i =0;i<s.length;i++)
		{
			if(s[i].point<avg)
			{
				System.out.println(s[i].name);
			}
		}
		sc.close();
		
		
	}

}
