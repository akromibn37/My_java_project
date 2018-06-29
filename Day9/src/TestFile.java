import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFile {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File f = new File("D://dict.txt");
		try {
			//FileWriter fw = new FileWriter(f);
			PrintWriter pw = new PrintWriter(f);
			pw.println("Hello");
			pw.print("My name is Kanut Boonroeangkaow.");
			pw.println("Google");
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
