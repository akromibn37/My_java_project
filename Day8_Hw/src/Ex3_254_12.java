import java.util.Scanner;

public class Ex3_254_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int s,mo,y,d,h,mi,ss;
		s = sc.nextInt();
		y = s/31104000;
		mo = (s-(y*31104000))/2592000;
		d = (s - (y*31104000) - (mo*2592000))/86400;
		h = (s-(y*31104000) - (mo*2592000)-(d*86400))/3600;
		mi = (s-(y*31104000) - (mo*2592000)-(d*86400) - (h*3600))/60;
		ss = s - (y*31104000) - (mo*2592000)-(d*86400) - (h*3600) - (mi*60);
		System.out.println( s + " second = "+ y + " year " + mo + " months " + d + " days " + h + " hours " + mi + " minutes " + ss + " second.");
		
	}

}
