package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.Globaldata;

public class SummaryManager {

	public static ArrayList<RoomsummaryDB> getAllUser(String month)
	{
		ArrayList<RoomsummaryDB> list = new ArrayList<RoomsummaryDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_summary WHERE month = '"+month+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        String id = rs.getString(1);
		        String monthe = rs.getString(2);
		        int room_price = rs.getInt(3);
		        int water  = rs.getInt(4);
		        int electric = rs.getInt(5);
		        int car = rs.getInt(6);
		        int motor = rs.getInt(7);
		        int internet = rs.getInt(8);
		        int total = rs.getInt(9);
		        String occu = rs.getString(10);
		        String pay = rs.getString(11);
		        
		        RoomsummaryDB cc = new RoomsummaryDB(id,monthe,room_price,water,electric,car,motor,internet,total,occu,pay);
		        list.add(cc);
		         
		        // print the results
		      //  System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, phone);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return list;
	}
	public static RoomsummaryDB getUser(String month,String xid)
	{
		RoomsummaryDB cc = new RoomsummaryDB();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_summary WHERE month = '"+month+"' AND room_id = '"+xid+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        String id = rs.getString(1);
		        String monthe = rs.getString(2);
		        int room_price = rs.getInt(3);
		        int water  = rs.getInt(4);
		        int electric = rs.getInt(5);
		        int car = rs.getInt(6);
		        int motor = rs.getInt(7);
		        int internet = rs.getInt(8);
		        int total = rs.getInt(9);
		        String occu = rs.getString(10);
		        String pay = rs.getString(11);
		        
		        cc = new RoomsummaryDB(id,monthe,room_price,water,electric,car,motor,internet,total,occu,pay);
		        
		         
		        // print the results
		      //  System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, phone);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return cc;
	}
	public static String getRoomID(String month,int xid)
	{	
		String id = "0";
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_summary WHERE month = '"+month+"' AND renter_id = '"+xid+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        id = rs.getString(1);
		        System.out.println(id);
		         
		        // print the results
		      //  System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, phone);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return id;
	}
	public static ArrayList<RoomsummaryDB> getAllUserForOwner(String month)
	{
		ArrayList<RoomsummaryDB> list = new ArrayList<RoomsummaryDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_summary WHERE month = '"+month+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		     
		      while (rs.next())
		      {
		        String id = rs.getString(1);
		        String monthe = rs.getString(2);
		        int room_price = rs.getInt(3);
		        int water  = rs.getInt(4);
		        int electric = rs.getInt(5);
		        int car = rs.getInt(6);
		        int motor = rs.getInt(7);
		        int internet = rs.getInt(8);
		        int total = rs.getInt(9);
		        String occu = rs.getString(10);
		        String pay = rs.getString(11);
		        		        
		        RoomsummaryDB cc = new RoomsummaryDB(id,monthe,room_price,water,electric,car,motor,internet,total,occu,pay);      
		        list.add(cc);
		         
		        // print the results
		      //  System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, phone);
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return list;
	}
	
}
