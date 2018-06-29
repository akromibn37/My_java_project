package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.Globaldata;

public class RoomdataManager {

	public static void addNewMonth(String month)
	{
		String [][]room = new String[][]{{"101","102","103","104","105"},{"201","202","203","204","205"},{"301","302","303","304","305"},{"401","402","403","404","405"},{"501","502","503","504","505"}};
		try
	    {
	      
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
	      	      
	      for(int i =0;i<5;i++)
	      {
	    	  for(int j = 0;j<5;j++)
	    	  {
	    		  String query = "INSERT INTO room_summary VALUES('"+room[i][j]+"','"+month+"', 0 , 0 , 0 , 0 , 0 , 0 , 'No' , 'No' , 0 )";		     
	    	      Statement st = conn.createStatement();
	    	     
	    	      st.executeUpdate(query); 
	    	      st.close();
	    	  }
	      }        
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }		 
	}
	
	public static ArrayList<RoomdataDB> getAllUser(String month)
	{
		ArrayList<RoomdataDB> list = new ArrayList<RoomdataDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_data WHERE month = '"+month+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        String id = rs.getString(1);
		        String monthe = rs.getString(2);		        
		        int water  = rs.getInt(3);
		        int electric = rs.getInt(4);
		        int car = rs.getInt(5);
		        int motor = rs.getInt(6);
		        String internet = rs.getString(7);
		        
		        RoomdataDB cc = new RoomdataDB(id,monthe,water,electric,car,motor,internet);
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
	
	public static void editRoomdata(RoomdataDB x)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "UPDATE room_data SET water = "+x.water_unit+", electric = "+x.electric_unit+""
		      				+ ", car_amount = "+x.car_unit+",motor_amount = "+x.motor_unit+""
		      				+ ",internet = '"+x.internet+"' WHERE room_id = "+x.room_id+" "
		      						+ "AND month = '"+x.month+"' ";
		 
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
	
	public static RoomsummaryDB getRoomsummary(RoomdataDB x)
	{		
		RoomrateDB thiis = new RoomrateDB();
		RoomsummaryDB total = new RoomsummaryDB();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      //Add data to RoomrateDB thiis
		      String query = "SELECT * FROM room WHERE id = '"+x.room_id+"'";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {
		    	  thiis.id = rs.getString(1);
		    	  thiis.room_price = rs.getInt(2);		        
		    	  thiis.water_price = rs.getInt(3); 
		    	  thiis.electricity_price = rs.getInt(4);
		    	  thiis.car_price = rs.getInt(5);
		    	  thiis.motor_price = rs.getInt(6);
		    	  thiis.internet_price = rs.getInt(7);
		      }
		      
		      st.close();
		      
		      //Calculate all and set to Roomsummary
		      int internet = x.internet.equals("Yes")? 1:0;
		      total.room_id = x.room_id;
		      total.month = x.month;
		      total.room_price = thiis.room_price;
		      total.water_sum = thiis.water_price * x.water_unit;
		      total.electric_sum = thiis.electricity_price * x.electric_unit;
		      total.car_sum = thiis.car_price * x.car_unit;
		      total.motor_sum = thiis.motor_price*x.motor_unit;
		      total.internet_sum = internet * thiis.internet_price;
		      total.totally();
		      		     	      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return total;
	}
	
	public static void editRoomsummary(RoomsummaryDB total)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		    //update to roomsummary
		      String  query = "UPDATE room_summary SET room_price = '"+total.room_price+"',water = "+total.water_sum+""
	      				+ ", electricity = "+total.electric_sum+", car = "+total.car_sum+",motorcycle = "+total.motor_sum+""
	      				+ ",internet = '"+total.internet_sum+"',total = '"+total.total+"' WHERE room_id = "+total.room_id+" "
	      				+ "AND month = '"+total.month+"' ";
		 
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

