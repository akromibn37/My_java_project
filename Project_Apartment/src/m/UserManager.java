package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import common.Globaldata;

public class UserManager {

	public static ArrayList<UserDB> getAllUser()
	{
		ArrayList<UserDB> list = new ArrayList<UserDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM users";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String username = rs.getString(2);		        
		        String password = rs.getString(3);
		        String usertype = rs.getString(4);
		        int rent_id = rs.getInt(5);
		        
		        UserDB cc = new UserDB(id,username,password,usertype,rent_id);
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
	
	public static void saveNewUser(UserDB x)
	{		
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
		      String query = "INSERT INTO users VALUES(0,'"+x.username+"','"+x.password +"','"+x.usertype+"', '"+x.renter_id+"' )";		     
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
	
	public static void editUser(UserDB x)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "UPDATE users SET username = '"+x.username+"', password = '"+x.password +"', type = '"+x.usertype+"' WHERE id = "+x.id;
		 
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
	public static void deleteUser(UserDB x)
	{		
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		     
		      String query = "DELETE FROM users WHERE id = "+x.id;
		 
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
	public static boolean checkLogin(String username,String password,String type)
	{

		try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
	       	      
	      String query = "SELECT * FROM users WHERE username = ? and password = ? and type = ?";	
	      System.out.println(query);
	      PreparedStatement st = (PreparedStatement) conn.prepareStatement(query);	  
	      st.setString(1, username);
	      st.setString(2, password);
	      st.setString(3, type);
	      
	      ResultSet rs = st.executeQuery();
	      
	      while (rs.next())
	      {
	        Globaldata.CurrentUser_userID = rs.getInt(1);
	        Globaldata.Current_username = rs.getString(2);
	        Globaldata.Current_usertype = rs.getString(4);
	        Globaldata.Current_renterID = rs.getInt(5);
	        return true;
	        
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return false;
	}
}
