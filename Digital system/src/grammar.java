import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class grammar {
	
	static String current_token;
	static int count;
	static ArrayList<String> text = new ArrayList<String>();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Bank account.txt");
			
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNext())
			{	
				text.addAll(Arrays.asList(sc.nextLine().split("[() {};	]")));
				
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		
		current_token = text.get(0);
		count = 0;
		System.out.println(text);
		for(int i=0;i<text.size();i++)
		{
			if("".equals(text.get(i)))
			{
				text.remove(i);
//				System.out.println("get in");
			}
			else
			{
				System.out.println(text.get(i));
			}
		}
		System.out.println(text);
		lang(text);
		System.out.println("Correct grammar");
		
	}
	public static void lang(ArrayList<String> text)
	{
		if(count<text.size())
		{
			if(!text.get(count).equals(""))
			{
				op(text.get(count));
				oprand(text.get(count));
				lang(text);
			}
		}		
		
	}
	public static void op(String token)
	{
		if(token.equals("MOV") ){match("MOV");}
		else if(token.equals("CLRA") ){match("CLRA");}
		else if(token.equals("ADD") ){match("ADD");}
		else if(token.equals("MOVA") ){match("MOVA");}
		else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
	}
	public static void oprand(String token)
	{
		String token1 = token.substring(1, 2);
		if(token.length()>2)
		{
			if(token.charAt(2) == ',')
			{
				String token2 = token.substring(3);
				if(reg(token))
				{				
					if(token1.matches("[-+]?\\d*\\.?\\d+"))
					{
						if(Integer.parseInt(token1)<=9)
						{
							if(token2.matches("[-+]?\\d*\\.?\\d+"))
							{
								if(Integer.parseInt(token2)>=100 && Integer.parseInt(token2)<=999)
								{
									match(token);
								}
								else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
							}
							else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
						}
						else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
					}
					else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
				}
			}			
		}
		else if(reg(token))
		{
			if(token1.matches("[-+]?\\d*\\.?\\d+"))
			{
				if(Integer.parseInt(token1)<=9)
				{
					match(token);
				}
				else{System.out.println("Token "+ token +" Wrong Grammar"); System.exit(0);}
			}
		}		
		
	}
	public static boolean opcheck(String token)
	{
		if(token.equals("MOV")){return true;}
		else if(token.equals("CLRA")){return true;}
		else if(token.equals("ADD")){return true;}
		else if(token.equals("MOVA")){return true;}
		return false;
	}
	public static boolean reg(String token)
	{
		if(token.charAt(0)=='R')
		{
			return true;
		}
		return false;
	}
	public static void match(String token)
	{
		if(current_token.equals(token))
		{
			System.out.println("Token " + token + " Matched");
			count++;
			if(count< text.size())
			{
				current_token = text.get(count);
			}			
		}
		else
		{
			System.out.println("Wrong Grammar");
			System.exit(0);
		}
	}	

}
