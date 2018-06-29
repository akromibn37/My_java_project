import java.util.Scanner;

public class if_else_1_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double n, interest,total;
		int year = 0;
		System.out.print("Please input your amount and interest : ");
		n = sc.nextInt();
		interest= sc.nextInt();
		total = 0;
		while(year<30){
			total = (total+n)*((100+interest)/100);
			year++;
			System.out.println("Your amount year "+year+ " is "+total+ "bath");
		}
		System.out.println("Your total money 10 years is " + total);
	}

}
