package m;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import common.Globaldata;
import v.RenterRegisframe;

public class RenterManager {

	public static ArrayList<RenterDB> getAllUser()
	{
		ArrayList<RenterDB> list = new ArrayList<RenterDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM renter";		 
		      Statement st = conn.createStatement();		    
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String personal_id = rs.getString(2);
		        String name = rs.getString(3);		        
		        String surname = rs.getString(4);
		        String phone = rs.getString(5);
		        String house_number = rs.getString(6);
		        String road = rs.getString(7);		        
		        String soi = rs.getString(8);
		        String tambon = rs.getString(9);
		        String district = rs.getString(10);
		        String province = rs.getString(11);		        
		        String postal_code = rs.getString(12);
		        String occupation = rs.getString(13);
		        String company_name = rs.getString(14);
		        String salary = rs.getString(15);
		        Date checkin = rs.getDate(16);
		        Date checkout = rs.getDate(17);		        
		        byte[] buffer = rs.getBytes(18);
		        BufferedImage b = null;
		        
		        if(buffer == null || buffer.length == 0 )
		        {}
		        else
		        {		        
		        	ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		        	b = ImageIO.read(bais);
		        	bais.close();
		        }
		        
		        RenterDB cc = new RenterDB(id,personal_id,name,surname,phone,house_number,road,soi,tambon,district,province,postal_code,occupation
		        		,company_name,salary,checkin,checkout,b);
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
	
	public static int saveNewUser(RenterDB x)
	{		
		int k = 0;
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
		      String query = "INSERT INTO renter VALUES(0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";		
		      
		      PreparedStatement queryStatement = conn.prepareStatement(query);
		      queryStatement.setString(1, x.personal_id);
		      queryStatement.setString(2, x.name);
		      queryStatement.setString(3, x.surname);
		      queryStatement.setString(4, x.phone);
		      queryStatement.setString(5, x.house_number);
		      queryStatement.setString(6, x.road);
		      queryStatement.setString(7, x.soi);
		      queryStatement.setString(8, x.tambon);
		      queryStatement.setString(9, x.district);
		      queryStatement.setString(10, x.province);
		      queryStatement.setString(11, x.postal_code);
		      queryStatement.setString(12, x.occupation);
		      queryStatement.setString(13, x.company_name);
		      queryStatement.setString(14, x.salary);
		      queryStatement.setDate(15, x.checkin);
		      queryStatement.setNull(16, java.sql.Types.DATE);
		      
		      ByteArrayOutputStream outstream = new ByteArrayOutputStream();
		      ImageIO.write(x.image, "png", outstream);
		      byte[] buffer = outstream.toByteArray();
		      queryStatement.setBytes(17 , buffer);
		      outstream.close();
		     
		      queryStatement.executeUpdate();
		      System.out.println("Record is inserted into renter table!");
		      queryStatement.close();
		      
		      query = "SELECT id FROM renter WHERE personal_id = '"+x.personal_id+"'";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		    	  k = rs.getInt(1); 
		      }
		      st.close();
		     
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	
		 return k;
	}
	
	public static void editUser(RenterDB x)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      System.out.println(x.renter_id + "," + x.personal_id + "," + x.name + "," + x.surname + "," + x.phone + "," + x.house_number + "," + x.road + "," + x.soi + "," + x.tambon + "," + x.district + "," + x.province + "," + x.postal_code + "," + x.occupation + "," +x.company_name+ "," + x.salary);
			
		      String query = "UPDATE renter SET personal_id= '"+x.personal_id+"',name= '"+x.name+"',surname= '"+x.surname+"'"
		      				+ ",phone='"+x.phone+"',house_number='"+x.house_number+"',road='"+x.road+"',soi='"+x.soi+"'"
		      				+ ",tambon= '"+x.tambon+"',district='"+x.district+"',province='"+x.province+"',postal_code='"+x.postal_code+"'"
		      				+ ",occupation= '"+x.occupation+"',company_name='"+x.company_name+"',salary='"+x.salary+"'"
		      				+ " WHERE id = '"+x.renter_id+"'";
		 
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
	public static void deleteUser(int x)
	{		
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		     
		      String query = "DELETE FROM renter WHERE id = "+x;
		 
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
	
	public static void InsertRenterToRoom(String room,int renter_id,String month)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
			
		      String query = "UPDATE room_summary SET renter_id = '"+renter_id+"', occupy_status = 'Yes' WHERE room_id = '"+room+"' AND month = '"+month+"'";
		 
		      Statement st = conn.createStatement();
		   
		      st.executeUpdate(query);		       
		     
		      
		      st.close();
		      System.out.println("Update finished");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	public static boolean IsOccupy(String room_id,String month)
	{
		boolean occu = false;
		 	try
		    {
		      String k = null;
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
		          
		      String query = "SELECT occupy_status FROM room_summary WHERE room_id = '"+room_id+"' AND month = '"+month+"'";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		    	  k = rs.getString(1); 
		    	  System.out.println("get in");
		      }
		      st.close();
		      if(k.equals("Yes"))
		      {
		    	  occu =true;
		      }
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	
		 return occu;
	}
	
	public static boolean Isroom(String room_id)
	{
		boolean occu = false;		
	 	try
	    {	   
	 	  String k = null;	
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
	          
	      String query = "SELECT id FROM room";
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	       
	      while (rs.next())
	      {
	    	  k=rs.getString(1);
	    	  if(k.equals(room_id))
	    	  {
	    		occu= true;
	    		return occu;
	    	  }	    	  
	      }
	      st.close();	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }	
	 	return occu;
	}
	
	public static boolean checkPayment(String room_id,String month)
	{
		boolean occu = false;
	 	try
	    {
	      String k = null;
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
	          
	      String query = "SELECT pay_status FROM room_summary WHERE room_id = '"+room_id+"' AND month = '"+month+"'";
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery(query);
	       
	      while (rs.next())
	      {
	    	  k = rs.getString(1); 
//	    	  System.out.println("get in");
	      }
	      st.close();
	      if(k.equals("Yes"))
	      {
	    	  occu =true;
	      }
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	     
	    }	
	 	return occu;
	}
	
	public static void UpdateCheckout(String room,String month,String renter_id)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
			
		      String query = "UPDATE room_summary SET renter_id = 0, occupy_status = 'No' ,pay_status = 'No' WHERE room_id = '"+room+"' AND month = '"+month+"'";
		      Statement st = conn.createStatement();
		      st.executeUpdate(query);		       
		      
		      query = "DELETE FROM users WHERE renter_id = "+renter_id;
		      st = conn.createStatement();			   
		      st.executeUpdate(query);
		      
		      Date checkout = new Date(Calendar.getInstance().getTime().getTime());
		      query = "UPDATE renter SET check_out = '"+checkout+"' WHERE id = '"+renter_id+"'";
		      st = conn.createStatement();			   
		      st.executeUpdate(query); 
		      
		      st.close();
		      System.out.println("Update finished");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	public static String GetRenterID(String room_id,String month)
	{
		String rid = null;
		 	try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);		       
		          
		      String query = "SELECT renter_id FROM room_summary WHERE room_id = '"+room_id+"' AND month = '"+month+"'";
		      Statement st = conn.createStatement();
		      ResultSet rs = st.executeQuery(query);
		       
		      while (rs.next())
		      {
		    	  rid = rs.getString(1); 
		    	  //System.out.println("get in");
		      }
		      st.close();		      
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }	
		 return rid;
	}
	public static void UpdatePayment(String room,String month)
	{		
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
			
		      String query = "UPDATE room_summary SET pay_status = 'Yes' WHERE room_id = '"+room+"' AND month = '"+month+"'";
		      Statement st = conn.createStatement();
		      st.executeUpdate(query);    
		      
		     
		      
		      st.close();
		      System.out.println("Payment Update finished");
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
}
