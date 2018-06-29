import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Error_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Error test find solution,test printwriter,test FileOutputStream
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\aaa.txt");
		FileOutputStream outs = null;
		try {
			outs = new FileOutputStream(f,true);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PrintWriter pw = null;
		pw = new PrintWriter(outs);
		pw.print("hahaha");
		pw.close();		
	}

}
