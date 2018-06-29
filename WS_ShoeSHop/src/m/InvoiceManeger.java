package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.Globaldata;

public class InvoiceManeger 
{
	public static void saveInvoice(CustomerDB cust,ArrayList<InvoiceDetail> details)
	{
		try
	    {
	      
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
	      Class.forName(myDriver);
	      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);	       
	     
	      String query = "INSERT INTO invoice VALUES(0, NOW(),'"+cust.id+"','NORMAL' )";      
	      Statement st = conn.createStatement();      
	      st.executeUpdate(query); 
	      
	      query = "SELECT MAX(invoice_id) FROM invoice";
	      st = conn.createStatement(); 
	      ResultSet rs = st.executeQuery(query);	
	      int id_max = 0;
	      while (rs.next())
	      {
	    	  id_max = rs.getInt(1);
	      }
	      for(int i= 0 ;i<details.size();i++)
	      {
	    	  query = "INSERT INTO invoice_detail VALUES(0, '"+id_max+"','" +details.get(i).product.product_id+"','"+details.get(i).qty+"' )";
	    	  st = conn.createStatement();      
	    	  st.executeUpdate(query); 
	      }
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }		 
	}
}
