
public class tokennum {

	public String word;
	public int token_num;
	public tokennum()
	{
		
	}
	public tokennum(String x,int y)
	{
		word = x;
		token_num = y;
	}	

	
	public tokennum change(String x,int y)
	{
		tokennum k = new tokennum();
		k.token_num = y;
		k.word = x;
		return k;
	}

}
