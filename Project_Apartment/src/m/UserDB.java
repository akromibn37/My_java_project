package m;

public class UserDB {

	public int id;
	public String username;
	public String password;
	public String usertype;
	public int renter_id;
	
	public UserDB()
	{}
	
	public UserDB(int xid,String xusername,String xpass,String xtype,int xrenter)
	{
		id = xid;
		username = xusername;
		password = xpass;
		usertype = xtype;
		renter_id = xrenter;
	}
	
}
