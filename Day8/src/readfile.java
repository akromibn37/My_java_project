import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class readfile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub		
		//test read file
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\aaa.txt");
		Scanner sc = new Scanner(f);
		
		while(sc.hasNext())
		{
			String s =sc.nextLine();
			System.out.println(s);
		}
		sc.close();
	}

}
