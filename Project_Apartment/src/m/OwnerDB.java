package m;

public class OwnerDB {
	
	public int month_id;
	public String month;
	public int occupied;
	public int vacant;
	public int total;
	public int checkin;
	public int checkout;
	
	public OwnerDB()
	{		
	}
	
	public OwnerDB(int xmonth_id,String xmonth,int xoccupied,int xvacant,int xtotal,int xcheckin,int xcheckout)
	{
		month_id = xmonth_id;
		month = xmonth;
		occupied = xoccupied;
		vacant = xvacant;
		total = xtotal;
		checkin = xcheckin;
		checkout = xcheckout;			
	}
	

}
