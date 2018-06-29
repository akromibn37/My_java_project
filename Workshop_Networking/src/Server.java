import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Server 
{

	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket ss = new ServerSocket(123);
			System.out.println("start server ... ");
			Socket socket = ss.accept();
			
			Scanner sc = new Scanner(socket.getInputStream());
			String s = sc.nextLine();
			Calendar now = Calendar.getInstance();
			SimpleDateFormat format1 = new SimpleDateFormat("HH-mm-ss");
			s = s.toUpperCase() + "  "+format1.format(now.getTime());
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(s);
			pw.flush();
			
			ss.close();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
		
	}

}
