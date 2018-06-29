import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Bank_accountFunc {

	public Bank_accountFunc()
	{}
	
	public void withdraw(String account_number,String password,int amount) throws FileNotFoundException
	{		
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Bank account.txt");
		Scanner sc =null;
		String text = "";
		sc = new Scanner(f);
		while(sc.hasNext())
		{
			
			text = sc.nextLine();
			String text1=text;
			System.out.println(text);
			int pos = 0;
			pos = text.indexOf(" ");
			System.out.println(pos);
			String account = text.substring(0, pos);
			System.out.println(account);
			text = text.substring(pos).trim();
			if(account.equals(account_number))
			{
				pos = text.indexOf(" ");
				text = text.substring(pos+1);
				pos = text.lastIndexOf(" ");
				String pass = text.substring(0, pos);
				text = text.substring(pos+1);
				if(pass.equals(password))
				{
					int am = Integer.parseInt(text);
					if(amount > am)
					{
						System.out.println("you not have enough money");
					}
					else
					{
						am = am-amount;
						System.out.println(am);
						pos = text1.lastIndexOf(" ");
						text1= text1.substring(0, pos);
						text1 = text1.concat(" " + am);
						System.out.println(text1);
						PrintWriter te = new PrintWriter(f);
						te.flush();
						te.print(text1);
						te.close();
					}
				}
				else
				{
					System.out.println("password wrong");
				}
				break;
			}			
		}		
	}
	public void deposit()
	{
		
	}
}
