package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*;

import common.Globaldata;

public class RoomrateManager {

	public static ArrayList<RoomrateDB> getAllRate()
	{
		ArrayList<RoomrateDB> list = new ArrayList<RoomrateDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        String id = rs.getString(1);
		        int price = rs.getInt(2);		        
		        int water_price = rs.getInt(3); 
		        int electric_price = rs.getInt(4);
		        int car_price = rs.getInt(5);
		        int motor_price = rs.getInt(6);
		        int internet_price = rs.getInt(7);
		        
		        RoomrateDB cc = new RoomrateDB(id,price,water_price,electric_price,car_price,motor_price,internet_price);
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
	
	public static void editUser(RoomrateDB x)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "UPDATE room SET price = '"+x.room_price +"', water_per_unit = '"+x.water_price+"' "
		      				+ ", electric_per_unit = '"+x.electricity_price+"' , car_price = '"+x.car_price+"' "
		      				+ ", motor_price = '"+x.motor_price+"' , internet_price = '"+x.internet_price+"' "
		      				+ "WHERE id = "+x.id;
		 
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
}
