import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testReadFile {

	public static void main(String[] args) 
	{
		File f = new File("D://dict.txt");
		Scanner sc = null;
		try {
			System.out.println("Start read File");
			sc = new Scanner(f);
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				System.out.println(s);
			}
			System.out.println("End read File");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("This is Error.");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("This is Finally");
			if(sc!= null)
			{
				sc.close();
			}
		}
		
		
	}

}
