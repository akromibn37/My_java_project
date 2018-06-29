import java.util.Scanner;

public class array_129_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []name = new String [10];
		String []surname = new String[10];
		int []score = new int[10];
		Scanner sc =new Scanner(System.in);
		for(int i =0;i<score.length;i++){
			System.out.print("Input name :");
			name[i]=sc.nextLine();
			System.out.print("Input surname : ");
			surname[i] = sc.nextLine();
			System.out.println("Input score : ");
			score[i] =sc.nextInt();
			sc.nextLine();//protect error because nextint not have to goto nextline
		}
		int max = Integer.MIN_VALUE;
		int max_index = -1; 
		for(int i =0;i<score.length;i++){
			if(score[i]>max){
				max = score[i];
				max_index = i;
			}
		}
		System.out.println(name[max_index] + " " + surname[max_index] + " " + score[max_index]);
	}

}
