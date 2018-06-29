import java.util.Scanner;

public class array_extra3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []x = new int[100];
		double []y = new double[100];
		int i =0;
		int k;
		int max_power = 0;
		double a,b;
		Scanner sc =new Scanner(System.in);
		System.out.println("input max power : ");
		max_power = sc.nextInt();
		while(true){
			System.out.print("input coef(or -999)");
			k=sc.nextInt();
			if(k==-999){
				break;
			}
			else{
				x[i]=k;
				i++;
			}
		}
		System.out.print("input border a,b: ");
		a=sc.nextDouble();
		b=sc.nextDouble();
		for(int j=0;j<i;j++){
			if(max_power-j != -1){
			y[j] = (double)x[j]/(max_power+1-j);}
			else{
				y[j]=(double)x[j]*Math.log(x[j]);
			}
		}
		double sum_a,sum_b;
		sum_a=0;sum_b=0;
		for(int j=0;j<i;j++){
			sum_a += y[j]*Math.pow(a, max_power+1-j);
			sum_b += y[j]*Math.pow(b, max_power+1-j);
		}
		System.out.println(sum_b-sum_a);
	}

}
