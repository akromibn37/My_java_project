
public class mainStudent extends Student{
	
	public mainStudent(String ID,String name,String surname,int point)
	{
		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.point = point;
	}
	
	public String max(mainStudent[] s)
	{
		int max = Integer.MIN_VALUE;
		String StuMax = "";
		for(int i =0;i<s.length;i++)
		{
			if(s[i].point>max)
			{
				max = s[i].point;
				StuMax =s[i].name;
				
			}
		}
		return StuMax;
	}
	public String min(mainStudent[] s)
	{
		int min = Integer.MAX_VALUE;
		String StuMin = "";
		for(int i =0;i<s.length;i++)
		{
			if(s[i].point<min)
			{
				min = s[i].point;
				StuMin =s[i].name;
				
			}
		}
		return StuMin;
	}
	public double avg(mainStudent[] s)
	{
		double sum = 0;
		for(int i = 0;i<s.length;i++)
		{
			sum += s[i].point;
		}
		return sum/s.length;
	}
}
