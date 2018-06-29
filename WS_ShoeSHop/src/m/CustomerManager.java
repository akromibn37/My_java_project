package m;

import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;


import common.Globaldata;

public class CustomerManager {
	
	public static ArrayList<CustomerDB> getAllCustomer()
	{
		ArrayList<CustomerDB> list = new ArrayList<CustomerDB>();
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "SELECT * FROM customer2";
		 
		     
		      Statement st = conn.createStatement();
		      
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String firstName = rs.getString(2);		        
		        String lastName = rs.getString(3);
		        String phone = rs.getString(4);
		        
		        CustomerDB cc = new CustomerDB(id,firstName,lastName,phone);
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
	
	public static void saveNewCustomer(CustomerDB x)
	{		
		 try
		    {
		      // create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "INSERT INTO customer2 VALUES(0,'"+x.name+"','"+x.surname +"','"+x.phone+"' )";
		 
		      // create the java statement
		      Statement st = conn.createStatement();
		       
		      // execute the query, and get a java resultset
		      int i = st.executeUpdate(query); 
		      
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static void editCustomer(CustomerDB x)
	{		
		 try
		    {
		      // create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "UPDATE customer2 SET name = '"+x.name+"', surname = '"+x.surname +"', phone = '"+x.phone+"' WHERE id = "+x.id;
		 
		      // create the java statement
		      Statement st = conn.createStatement();
		       
		      // execute the query, and get a java resultset
		      int i = st.executeUpdate(query);		       
		     
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static void deleteCustomer(CustomerDB x)
	{		
		 try
		    {
		      // create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "DELETE FROM customer2 WHERE id = "+x.id;
		 
		      // create the java statement
		      Statement st = conn.createStatement();
		       
		      // execute the query, and get a java resultset
		      int i = st.executeUpdate(query);		       
		     
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static ArrayList<CustomerDB> SearchCustomer(String s)
	{
		ArrayList<CustomerDB> list = new ArrayList<CustomerDB>();
		 try
		    {
		      
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		      
		      String query = "SELECT * FROM customer2 WHERE name LIKE '"+s+ "' OR surname LIKE '"+s+"' ";
		 
		     
		      Statement st = conn.createStatement();
		      
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String firstName = rs.getString(2);		        
		        String lastName = rs.getString(3);
		        String phone = rs.getString(4);
		        
		        CustomerDB cc = new CustomerDB(id,firstName,lastName,phone);
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
	public static void main(String [] args)
	{
		ArrayList<CustomerDB> ll = CustomerManager.getAllCustomer();
		System.out.println(ll.size());
	}
}
