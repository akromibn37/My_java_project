import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex4_269_4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Desktop\\Eclipse\\aaa.txt"));
		String line;
		while((line = in.readLine()) != null)
		{
		    System.out.println(line);
		}
		in.close();
		
	}

}
