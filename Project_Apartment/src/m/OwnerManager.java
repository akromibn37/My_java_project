package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.Globaldata;

public class OwnerManager {

	public static ArrayList<OwnerDB> getAllUser()
	{
		ArrayList<OwnerDB> list = new ArrayList<OwnerDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM Owner_status";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String month= rs.getString(2);		        
		        int occupy = rs.getInt(3);
		        int vacant = rs.getInt(4);
		        int total = rs.getInt(5);
		        int checkin = rs.getInt(6);
		        int checkout = rs.getInt(7);
		        
		        OwnerDB cc = new OwnerDB(id,month,occupy,vacant,total,checkin,checkout);
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
	
	public static void editdata(int occupied,int vacant,int total,String month)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "UPDATE owner_status SET occupy = '"+ occupied +"', vacant = '"+ vacant +"', total = '"+ total +"' WHERE month = '"+month+"'" ;
		 
		      Statement st = conn.createStatement();
		   
		      st.executeUpdate(query);		       
		     
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static void editcheckin(String month)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "SELECT check_in FROM owner_status WHERE month = '"+ month+"'";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      int checkin = 0;
		      while (rs.next())
		      {
		    	  int id = rs.getInt(1);
		    	  
		    	  checkin = ++id;
		        
		      }
		      
		      query = "UPDATE owner_status SET check_in = '"+ checkin +"' WHERE month = '"+month+"'";		      
		   
		      st.executeUpdate(query);		       
		     
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	public static void editcheckout(String month)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "SELECT check_out FROM owner_status WHERE month = '"+ month+"'";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		      int checkout = 0;
		      while (rs.next())
		      {
		    	  int id = rs.getInt(1);
		    	  
		    	  checkout = ++id;
		        
		      }
		      
		      query = "UPDATE owner_status SET check_out = '"+ checkout +"' WHERE month = '"+month+"'";		      
		   
		      st.executeUpdate(query);		       
		     
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
}
