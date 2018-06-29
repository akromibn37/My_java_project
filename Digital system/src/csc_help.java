import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class csc_help {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\multicycle.txt");
		File file = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\multiout.txt");
		PrintWriter pw = new PrintWriter(file);
		String text;
		try {
			Scanner sc = new Scanner(f);
			int i =1;
			while(sc.hasNext())
			{	
				text = sc.nextLine();
				if(text.charAt(0) == 'a')
				{
					text = text.substring(0,65);
					pw.println(i + " : " + text);
					System.out.println(i + " : " + text);
					i++;
				}
				/*if(text.contains("stop = 1"))
				{
					System.out.println("Break");
				}*/
				
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}		
	}

}
