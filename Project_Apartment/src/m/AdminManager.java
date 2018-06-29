package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.*;

import java.sql.Connection;


import common.Globaldata;

public class AdminManager {

	public static ArrayList<AdminDB> CheckOccupy(String month)
	{
		ArrayList<AdminDB> list = new ArrayList<AdminDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       		     
		      String query = "SELECT * FROM room_summary WHERE month = '"+month+"'";
		      Statement st = conn.createStatement(); 		      
		      ResultSet rs = st.executeQuery(query);
		      
		      int i =0;
		      while (rs.next())
		      {
		    	  String room =rs.getString(1);
		    	  String status = rs.getString(10);
		    	  AdminDB a = new AdminDB();
		    	  a.room = room;
		    	  a.Status = status;
		    	  list.add(a);
		         
		        // print the results
		        System.out.format("%s, %s \n", a.room, a.Status);
		        i++;
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
