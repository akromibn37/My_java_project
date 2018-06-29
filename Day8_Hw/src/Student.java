import java.util.Scanner;

public class Student {
	public String ID,name,surname,grade;
	public int point;
	
	public Student()
	{}
	
	public Student(String ID,String name,String surname,int point)
	{
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.point = point;
	}
	
//	public void filldata()
//	{
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Input ID : ");
//		ID = sc.nextLine();
//		System.out.print("Input Name : ");
//		name = sc.nextLine();
//		System.out.print("Input Surname : ");
//		surname = sc.nextLine();
//		System.out.print("Input Points : ");
//		point = sc.nextInt();
//		s[i] = new mainStudent(ID,name,surname,point);
//		s[i].grade = s[i].Grade(s[i].point);
//		sc.nextLine();	
//		System.out.println();
//	}
	public String Grade(int point)
	{
		if(point >= 80)
		{
			return "A";
		}
		else if(point >=70)
		{
			return "B";
		}
		else if(point >= 60)
		{
			return "C";
		}
		else if(point >=50)
		{
			return "D";
		}
		else 
		{
			return "F";
		}
	}
	public void Print(Student a)
	{		
		System.out.println(a.ID + "\t " +a.name + "\t" +a.surname + "\t"+ a.point + "\t"+a.grade);
	}
}

