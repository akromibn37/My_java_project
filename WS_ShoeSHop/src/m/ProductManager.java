package m;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import common.Globaldata;

public class ProductManager 
{
	public static ArrayList<ProductDB> getAllProduct()
	{
		ArrayList<ProductDB> list = new ArrayList<ProductDB>();
		 try
		    {
		      // create our mysql database connection
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       
		      // our SQL SELECT query. 
		      // if you only need a few columns, specify them by name instead of using "*"
		      String query = "SELECT * FROM products";
		 
		      // create the java statement
		      Statement st = conn.createStatement();
		       
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		       
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String pName = rs.getString(2);		        
		        double price = rs.getDouble(3);
		        String pdes = rs.getString(4);
		        byte[] img_byte = rs.getBytes(5);
		        BufferedImage bufferedimg = null;
		        if(img_byte == null || img_byte.length == 0)
		        {
		        	
		        }
		        else
		        {
		        	
		        	ByteArrayInputStream bais = new ByteArrayInputStream(img_byte);
		        	bufferedimg = ImageIO.read(bais);
		        	bais.close();
		        }
		        ProductDB cc = new ProductDB(id,pName,price,pdes,bufferedimg);
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
	
	public static void saveProduct(ProductDB x)
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
		      String query = "INSERT INTO products VALUES(0,?,?,?,?)";
		 
		      // create the java statement
		      PreparedStatement st  = (PreparedStatement) conn.prepareStatement(query);
		      st.setString(1, x.product_name);
		      st.setDouble(2, x.price_per_unit);
		      st.setString(3, x.product_description);
		      
		      if(x.product_image != null)
		      {
		    	  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		    	  ImageIO.write(x.product_image, "png", outStream);
		    	  byte[] buffer = outStream.toByteArray();
		    	  st.setBytes(4, buffer);
		    	  outStream.close();
		      }
		      else
		      {
		    	  byte[] buffer = new byte[0];
		    	  st.setBytes(4, buffer);
		      }
		       
		      // execute the query, and get a java resultset
		      
		      st.executeUpdate();		      
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static void editProduct(ProductDB x)
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
		      String query = "UPDATE products SET product_name = ?, price_per_unit = ?, product_description = ?, product_image = ? WHERE product_id = ?";
		 
		      PreparedStatement st  = (PreparedStatement) conn.prepareStatement(query);
		      st.setString(1, x.product_name);
		      st.setDouble(2, x.price_per_unit);
		      st.setString(3, x.product_description);
		      
		      if(x.product_image != null)
		      {
		    	  ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		    	  ImageIO.write(x.product_image, "png", outStream);
		    	  byte[] buffer = outStream.toByteArray();
		    	  st.setBytes(4, buffer);
		    	  outStream.close();
		      }
		      else
		      {
		    	  byte[] buffer = new byte[0];
		    	  st.setBytes(4, buffer);
		      }
		      st.setInt(5, x.product_id);
		       
		      // execute the query, and get a java resultset
		      
		      st.executeUpdate();		      
		      
		      st.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static void deleteProduct(ProductDB x)
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
		      String query = "DELETE FROM products WHERE product_id = ?";
		 
		      // create the java statement
		      PreparedStatement preparedStmt = (PreparedStatement) conn.prepareStatement(query);
		      preparedStmt.setInt(1, x.product_id);
		 
		      // execute the preparedstatement
		      preparedStmt.executeUpdate();		       
		     
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }		 
	}
	
	public static ArrayList<ProductDB> SearchProduct(String s)
	{
		ArrayList<ProductDB> list = new ArrayList<ProductDB>();
		 try
		    {
		     
		      String myDriver = "org.gjt.mm.mysql.Driver";
		      String myUrl = "jdbc:mysql://"+ Globaldata.DATABASE_LOCATION  + Globaldata.DATABASE_PORT +"/"+ Globaldata.DATABASE_NAME;
		      Class.forName(myDriver);
		      Connection conn = (Connection) DriverManager.getConnection(myUrl, Globaldata.DATABASE_USERNAME, Globaldata.DATABASE_PASSWORD);
		       
		      
		      String query = "SELECT * FROM products WHERE product_name LIKE '"+s+"' OR product_description LIKE '"+s+"' "; 
		 
		      Statement st = conn.createStatement();
		     
		      ResultSet rs = st.executeQuery(query);
		     
		      while (rs.next())
		      {
		        int id = rs.getInt(1);
		        String pName = rs.getString(2);		        
		        double price = rs.getDouble(3);
		        String pdes = rs.getString(4);
		        byte[] img_byte = rs.getBytes(5);
		        BufferedImage bufferedimg = null;
		        if(img_byte == null || img_byte.length == 0)
		        {
		        	
		        }
		        else
		        {
		        	
		        	ByteArrayInputStream bais = new ByteArrayInputStream(img_byte);
		        	bufferedimg = ImageIO.read(bais);
		        	bais.close();
		        }
		        ProductDB cc = new ProductDB(id,pName,price,pdes,bufferedimg);
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
