
public class Ex4_267_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		a=3;b=4;c=12;
		if((a+b)==c){
			System.out.println("+");
		}
		else if((a-b)==c||(b-a)==c){
			System.out.println("-");
		}
		else if(a*b==c){
			System.out.println("*");
		}
		else if((a/b)==c||(b/a)==c){
			System.out.println("/");
		}
		else{
			System.out.println("No");
		}
	}

}
