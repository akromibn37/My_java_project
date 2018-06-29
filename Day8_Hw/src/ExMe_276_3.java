
public class ExMe_276_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean n = isPrime(5);
		System.out.println(n);
		String s = dayOfWeek(4,6,2559);
		System.out.println(s);
	}
	public static boolean isPrime(int n)
	{
		boolean x = true;
		for(int i =2;i<=n;i++)
		{			
			if(i!=n && n%i==0)
			{				
				x = false;				
			}
		}
		return x;
	}
	public static String dayOfWeek(int d,int m,int y)
	{
		int date,firstday,day;
		String s = "";
		date = ((m - 1) * 30) + d;
		if(m >1){
			if(m ==3 || m ==6||m ==7){
				date-=1;
			}
			else if(m ==9||m==10){
				date-=3;
			}
			else if(m ==11||m==12){
				date-=4;
			}
			else if(m ==8){
				date-=2;
			}
			else if(m ==2){
				date+=1;
			}
		}
		if(y%4==3 && m>2){
			date +=1;
		}
		firstday = 5-((2559-y)%7)+((2559-y)/4);
		System.out.println(firstday);
		if(firstday<0)
		{
			firstday = 7-firstday;
		}
		System.out.println(firstday);
		
		day = ((date%7)-1)+firstday;
		if(day>7)
		{
			day = Math.abs(7-day);
		}
		System.out.println(day);
		switch (day) {
        case 1:  s = "Monday";
                break;
        case 2:  s = "Tuesday";
        		break;
        case 3:  s = "Wednesday";
        		break;    
        case 4:  s = "Thursday";
        		break;      
        case 5:  s = "Friday";
        		break;       
        case 6:  s = "Saturday";
        		break;      
        case 7:  s = "Sunday";
        		break;
        }
                 
        return s;
    }		
	

}
