import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CnnRss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			URL rss = new URL("http://rss.cnn.com/rss/edition.rss");
			BufferedReader in = new BufferedReader(new InputStreamReader(rss.openStream()));
			Scanner sc = new Scanner(in);
			while(sc.hasNext())
			{
				String s = sc.nextLine();
				int c = s.indexOf("<item>");
				if(c==-1){continue;}						
				int a = s.indexOf("<title>");
				if(a==-1){continue;}
				int b = s.indexOf("<title>");
				if(b == -1){continue;}
				String s2 = s.substring(a+7, b);
				System.out.println(s);
				System.out.println(s2);
//				if(s == null)
//				{
//					break;
//				}
			}
			sc.close();
		}		
		catch(IOException e)
		{e.printStackTrace();}
	}

}
