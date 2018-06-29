import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex4_269_6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\aaa.txt"));
		String []line = new String[100];
		int i = 0;
		int count=0;
		while((line[i] = in.readLine()) != null)
		{
			int countline =0;
		    System.out.println(line[i]);
		    System.out.println(line[i].length());
		    for(int j=0;j<line[i].length();j++)
		    {
		    	if(line[i].charAt(j)=='a' || line[i].charAt(j) =='e'||line[i].charAt(j) =='i'||line[i].charAt(j) =='0'||line[i].charAt(j) =='u')
		    	{
		    		count++;
		    		countline++;
		    	}
		    }
		    System.out.println("line"+ (i+1) + " = " +countline);
		    i++;
		}
		System.out.println(count);
		in.close();
	}

}
