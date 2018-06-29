import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Scanner;

public class Ex5_273_11 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		String s = sc.nextLine();
		s = "http://" +s;
		URL oracle = new URL(s);
        BufferedReader in = new BufferedReader(new InputStreamReader(oracle.openStream()));

        String inputLine;
        System.out.println("Input message you want to search : ");
        String search =sc.nextLine();
        while ((inputLine = in.readLine()) != null)
        {
        	if(inputLine.contains("<title>"))
        	{
        		if(inputLine.contains(search))
        		{
        			System.out.println(inputLine);
        			while ((inputLine = in.readLine()) != null)
        			{   
        				if(inputLine.contains("<p>"))
        				{
        					while(!(inputLine = in.readLine()).contains("</p>"))
        					{System.out.println(inputLine);}
        				}
        				        				
        			}
        		}
        		else{continue;}
        	}
        	
        }
        in.close();
		
	}

}
