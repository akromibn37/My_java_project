import java.util.Scanner;

public class Ex4_267_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int date, month, year, day;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input date month year : ");
		date = sc.nextInt();
		month = sc.nextInt();
		year = sc.nextInt();

		day = ((month - 1) * 30) + date;
		if(month >1){
			if(month ==3 || month ==6||month ==7){
				day-=1;
			}
			else if(month ==9||month==10){
				day-=3;
			}
			else if(month ==11||month==12){
				day-=4;
			}
			else if(month ==8){
				day-=2;
			}
			else if(month ==2){
				day+=1;
			}
		}
		if(year%4==3 && month>2){
			day +=1;
		}
		System.out.println("day = "+day);
	}

}
