package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;

import common.Globaldata;

public class CompanyInfoManager {
	public static CompanyInfoDB getCompanyInfo()
	{
		
		 try
		    {		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		     
		      String query = "SELECT * FROM company_info";		 
		      Statement st = conn.createStatement();		      
		      ResultSet rs = st.executeQuery(query);
		      
		      while (rs.next())
		      {       
		        
		    	CompanyInfoDB cc = new CompanyInfoDB();
		    	cc.id = rs.getInt("id");
		    	cc.company_name = rs.getString("company_name");
		    	cc.address = rs.getString("address");
		    	cc.phone = rs.getString("phone");
		    	cc.email = rs.getString("email");
		        return cc;
		       
		      }
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 return null;
		 
	}
	public static void editCompanyInfo(CompanyInfoDB x)
	{
		
		 try
		    {		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		     
		      String query = "UPDATE company_info SET company_name = '"+x.company_name+"', address = '"+x.address +"', phone = '"+x.phone+"', email = '"+x.email+"' WHERE id = "+x.id; 
		      Statement st = conn.createStatement();   
		      
		      
		      int i = st.executeUpdate(query);
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 
		 
	}
	public static void savenewCompanyInfo(CompanyInfoDB x)
	{
		
		 try
		    {		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		     
		      String query = "INSERT INTO company_info VALUES(0,'"+x.company_name+"','"+x.address +"','"+x.phone+"','"+x.email+"' )"; 
		      Statement st = conn.createStatement();   
		      
		      
		      int i = st.executeUpdate(query);
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
		 
		 
	}
}
