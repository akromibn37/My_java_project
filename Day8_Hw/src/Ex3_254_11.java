import java.util.Scanner;

public class Ex3_254_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sM,sD,sB,w,h;
		Scanner sc = new Scanner(System.in);
		System.out.print("Input weight and height : ");
		w = sc.nextDouble();
		h = sc.nextDouble();
		sM = Math.sqrt((w*h)/3600);
		sD = (71.84*(Math.pow(w, 0.425))*(Math.pow(h, 0.725)))/10000;
		sB = 0.0003207*(Math.pow(h, 0.3))*Math.pow((1000*w), (0.7285 - (0.0188*(3+Math.log10(w)))));
		System.out.println("Mosteller = " +sM);
		System.out.println("Dubois = " + sD);
		System.out.println("Boyd = " + sB);
		sc.close();
	}
	

}
