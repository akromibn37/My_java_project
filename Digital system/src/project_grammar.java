import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class project_grammar {

	static String current_token;
	static int count;
	static String parameter;
	static ArrayList<String> text = new ArrayList<String>();	
	static ArrayList<String> returntojava = new ArrayList<String>();	
	static Queue<tokennum> queue1 = new LinkedList<tokennum>();
	tokennum data = new tokennum();
	
	public static void main(String[] args) {		
		
		File f = new File("C:\\Users\\Administrator.MMTYOYDSVM1GISI\\Desktop\\Bank account.txt");
			
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNext())
			{	
				text.addAll(Arrays.asList(sc.nextLine().split("[ {};	]")));
				
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}		
		
		System.out.println(text);
		for(int i=0;i<text.size();i++)
		{
			if(text.get(i).equals(""))
			{
				text.remove(i);
//				System.out.println("get in");
				i--;
			}
			else
			{
				if(text.get(i).contains("("))
				{
					text.add(i, "(");
					text.add(i+1, text.get(i+1).substring(1));
					text.remove(i+2);					
					System.out.println(text.get(i));
				}
				else if((text.get(i).contains(")")) && (text.get(i).length() != 1))
				{
					text.add(i, text.get(i).substring(0, text.get(i).length()-1));
					text.add(i+1, ")");
					text.remove(i+2);
					i--;
				}
				else
				{
					System.out.println(text.get(i));
				}
			}
		}
		project_grammar x = new project_grammar();
		System.out.println(text);
		current_token = text.get(0);
		count = 0;
		x.lang(text);
		System.out.println("Correct grammar");
		x.convert(queue1);
		printreturntojava(returntojava);
		
	}
	public project_grammar()
	{}
	
	public void lang(ArrayList<String> text)
	{
		if(count<text.size())
		{
			if(!text.get(count).equals(""))
			{
				match("(");
				match("def");					
				queue1.add(data.change("def", 10));								
				
//				queue1.add(data.change("{", 0));				
				
				funcname(text.get(count),text.get(count+1));
				
				formalbody(text);				
				match(")");				
				
//				queue1.add(data.change("}", 1));				
				
				lang(text);				
			}
		}		
	}
	
	public void funcname(String token,String token2)
	{
		name(token);		
		queue1.add(data.change(token, 20));		
		
		param(token2);
		queue1.add(data.change(token2, 20));			
	}
	
	public static void name(String token)
	{
		if(!token.matches("[-+]?\\d*\\.?\\d+"))
		{
			match(token);
		}
	}
	
	public static void param(String token2)
	{
		if(token2.equals("n"))
		{
			parameter = "n";
			match(token2);			
		}
		else if(token2.equals("a"))
		{
			parameter = "a";
			match(token2);
		}
		else if(token2.equals("b"))
		{
			parameter = "b";
			match(token2);
		}
		else if(token2.equals("c"))
		{
			parameter = "c";
			match(token2);
		}
		else if(token2.equals("("))
		{
			match("(");
			match(")");
		}
		else
		{
			System.out.println("Wrong grammar");
			System.exit(0);
		}
		
	}	
	
	public void formalbody(ArrayList<String> text)
	{
		if(text.get(count+1).equals("ifelse"))
		{
			//ifelse
			match("(");
			match("ifelse");			
			queue1.add(data.change("ifelse", 30));
			match("(");
			cond(text);
			match(")");
			what(text);
			match(")");
		}
		else if(!text.get(count).equals(""))
		{
			//command
			command(text);
		}
		else
		{
			count++;
		}
	}
	
	public void cond(ArrayList<String> text)
	{
		sym1(text.get(count));		
		queue1.add(data.change(text.get(count-1), 31));
		
		param(text.get(count));		
		queue1.add(data.change(text.get(count-1), 31));
		
		num(text.get(count));		
		queue1.add(data.change(text.get(count-1), 31));
	}
	
	public void what(ArrayList<String> text)
	{
		if(text.get(count).matches("[-+]?\\d*\\.?\\d+"))
		{
			num(text.get(count));			
			queue1.add(data.change(text.get(count-1), 40));
			command(text);			
		}	
		else if(text.get(count).equals(")"))
		{
			count++;
		}
		else
		{
			System.out.println("Wrong grammar");
			System.exit(0);
		}
	}
	
	public static void sym1(String token)
	{
		if(token.equals("=="))
		{
			match(token);
		}
		else if(token.equals(">="))
		{
			match(token);
		}
		else if(token.equals("<="))
		{
			match(token);
		}
		else
		{
			System.out.println("Wrong grammar");
			System.exit(0);
		}
		
	}	
	
	public static void sym2(String token)
	{
		if(token.equals("+"))
		{
			match(token);
		}
		else if(token.equals("-"))
		{
			match(token);
		}
		else if(token.equals("*"))
		{
			match(token);
		}
		else if(token.equals("/"))
		{
			match(token);
		}
		else
		{
			System.out.println("Wrong grammar");
			System.exit(0);
		}
		
	}	
	
	public static void num(String token)
	{
		if(token.matches("[-+]?\\d*\\.?\\d+"))
		{
			if(Integer.parseInt(token)<=10)
			{
				match(token);
			}
			else
			{
				System.out.println("Cannot insert more than 10");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Wrong grammar");
			System.exit(0);
		}
		
	}
	
	public void command(ArrayList<String> text)
	{
		if(text.get(count+1).equals("print"))
		{
			match("(");
			match("print");			
			queue1.add(data.change("print", 41));
			
			func2(text);
			match(")");
		}
		else if(text.get(count).equals("("))
		{
			if(text.get(count+3).equals("("))
			{
				//assignment2
				if(text.get(count+6).matches("[-+]?\\d*\\.?\\d+"))
				{
					//model1
					match("(");
					sym2(text.get(count));					
					queue1.add(data.change(text.get(count-1), 53));
					
					param(text.get(count));					
					queue1.add(data.change(text.get(count-1), 53));
					func2(text);
					match(")");
				}
				else
				{
					//model2
					match("(");
					sym2(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					
					param(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					
					match("(");
					
					name(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					
					match("(");
					
					sym2(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					
					param(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					
					num(text.get(count));
					queue1.add(data.change(text.get(count-1), 52));
					match(")");
					match(")");	
					match(")");
				}
				
			}
			else
			{
				//assignment1
				match("(");
				sym2(text.get(count));
				queue1.add(data.change(text.get(count-1), 51));
				
				param(text.get(count));
				queue1.add(data.change(text.get(count-1), 51));
				
				num(text.get(count));
				queue1.add(data.change(text.get(count-1), 51));
				
				match(")");
			}
		}
		else
		{
			System.out.println("Wrong Grammar");
			System.exit(0);
		}
	}
	
	public void func2(ArrayList<String> text)
	{
		match("(");
		name(text.get(count));	
		queue1.add(data.change(text.get(count-1), 42));
		
		match("(");
		num(text.get(count));
		queue1.add(data.change(text.get(count-1), 42));
		
		match(")");
		match(")");
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
	
	public static void convert(Queue<tokennum> queue1)
	{
		tokennum dat = new tokennum();
		int i = queue1.size();		
		StringBuilder aa = new StringBuilder();
		String[] num20 = new String[2];
		String[] ifelse = new String[4];		
		System.out.println(queue1);
		System.out.println("queue data : " + i);
		int a = 1;
		for(tokennum n: queue1)
		{
			System.out.println(a + ":" + n.word + "," + n.token_num);
			a++;
		}
		
		while(!queue1.isEmpty())
		{			
			dat = queue1.poll();			
			if(dat.token_num == 10)
			{
				aa.append("public");
				dat = queue1.poll();
				num20[0] = dat.word;
				dat = queue1.poll();
				num20[1] = dat.word;
				if(num20[1].equals("("))
				{
					aa.append(" static void " + num20[0] + "() {");
					returntojava.add(aa.toString());
					aa.setLength(0);
					num20 = new String[num20.length];
				}
				else
				{
					aa.append(" static int " + num20[0] + "(" + "int " + num20[1] + ") {");
					returntojava.add(aa.toString());
					aa.setLength(0);
					num20 = new String[num20.length];
				}
				dat = queue1.poll();
				if(dat.token_num == 30)
				{
					dat = queue1.poll();
					ifelse[0] = dat.word;
					dat = queue1.poll();
					ifelse[1] = dat.word;
					dat = queue1.poll();
					ifelse[2] = dat.word;
					dat = queue1.poll();
					ifelse[3] = dat.word;
						
					aa.append("if(" + ifelse[1] + " " + ifelse[0] + " " + ifelse[2] + "){");
					returntojava.add(aa.toString());
					aa.setLength(0);
					aa.append("return " +ifelse[3] + ";}");
					returntojava.add(aa.toString());
					returntojava.add("else{ ");
					aa.setLength(0);
					dat = queue1.poll();
					changecommand(queue1,dat);
				}
				else
				{					
					changecommand(queue1,dat);
				}
//				System.out.println(returntojava);
			}					
		}
		
	}
	
	public static void changecommand(Queue<tokennum> queue1,tokennum dat)
	{		
		StringBuilder aa = new StringBuilder();
		
		if(dat.token_num == 41)
		{			
			String[] x = new String[2];
			dat = queue1.poll();
			x[0] = dat.word;
			dat = queue1.poll();
			x[1] = dat.word;
			aa.append("System.out.println(" + x[0] + "(" +x[1] + ");}");
			returntojava.add(aa.toString());
		}
		else if(dat.token_num == 51)
		{			
			String[] x = new String[3];
			x[0] = dat.word;
			dat = queue1.poll();
			x[1] = dat.word;
			dat = queue1.poll();
			x[2] = dat.word;
			aa.append("return " + x[1] + " " + x[0] + " " + x[2] +";}");
			returntojava.add(aa.toString());
		}
		else if(dat.token_num == 52)
		{			
			String[] x = new String[6];
			x[0] = dat.word;
			dat = queue1.poll();
			x[1] = dat.word;
			dat = queue1.poll();
			x[2] = dat.word;
			dat = queue1.poll();
			x[3] = dat.word;
			dat = queue1.poll();
			x[4] = dat.word;
			dat = queue1.poll();
			x[5] = dat.word;			
			aa.append("return (" + x[1] + x[0] + "(" + x[2] + "(" + x[4] + x[3] + x[5] +")));}");
			returntojava.add(aa.toString());
		}
		else if(dat.token_num == 53)
		{			
			String[] x = new String[4];
			x[0] = dat.word;
			dat = queue1.poll();
			x[1] = dat.word;
			dat = queue1.poll();
			x[2] = dat.word;
			dat = queue1.poll();
			x[3] = dat.word;
			aa.append("return (" + x[1] + " " + x[0] + "(" + x[2] + "(" + x[3] +")));}");
			returntojava.add(aa.toString());
		}
	}
	
	public static void printreturntojava(ArrayList<String> x)
	{
		for(String a:x)
		{
			System.out.println(a);
		}
	}
	
}
