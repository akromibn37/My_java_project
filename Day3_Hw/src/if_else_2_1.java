import java.util.Scanner;

public class if_else_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour,minute,tuition;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please input hour :");
		hour = sc.nextInt();
		System.out.print("Please input minute :");
		minute = sc.nextInt();
		System.out.print("Your tuition "+hour+" hour "+minute +" minute is ");
		if(hour == 0){
			tuition = 0;
		}
		else{
			if(minute!=0){
				tuition = hour*30;
			}
			else{
				tuition = (hour-1)*30;
			}
		}
		
		System.out.println(tuition + " bath");
	}

}
