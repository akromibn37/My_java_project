package m;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.util.VersionFSHierarchyMaker;

import common.GlobalData;

public class UserDBManager {
	public static ArrayList<UserDB> getAllUsers()
	{
		ArrayList<UserDB> list = new ArrayList<UserDB>();
		
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://"+ GlobalData.DatabaseHostName + ":3306/" + GlobalData.DatabaseName;
        String user = GlobalData.DatabaseUser;
        String password = GlobalData.DatabasePassword;
		  try {
	            con = (Connection) DriverManager.getConnection(url, user, password);
	            st = (Statement) con.createStatement();
	            rs = st.executeQuery("SELECT * FROM users");

	            while (rs.next()) {
	                UserDB x = new UserDB();
	                x.id = rs.getInt(1);
	                x.Username = rs.getString(2);
	                x.Password = rs.getString(3);
	                x.Usertype = rs.getString(4);
	                
	                list.add(x);
	            }

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
		
		return list;
	}
	
	public static void addNewUser(UserDB x)
	{
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://"+ GlobalData.DatabaseHostName + ":3306/" + GlobalData.DatabaseName;
        String user = GlobalData.DatabaseUser;
        String password = GlobalData.DatabasePassword;
		  try {
	            con = (Connection) DriverManager.getConnection(url, user, password);
	            st = (Statement) con.createStatement();
	            int i = st.executeUpdate("INSERT INTO users VALUES(0,'"+x.Username+"','"+x.Password +"','"+x.Usertype+"' )");
	            
	           

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
	}
	
	public static void updateUser(UserDB x)
	{
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://"+ GlobalData.DatabaseHostName + ":3306/" + GlobalData.DatabaseName;
        String user = GlobalData.DatabaseUser;
        String password = GlobalData.DatabasePassword;
		  try {
	            con = (Connection) DriverManager.getConnection(url, user, password);
	            st = (Statement) con.createStatement();
	            String sql = "UPDATE users SET name = '"+x.Username+"', lastname = '"+x.Password +"', phone = '"+x.Usertype+"' WHERE id = "+x.id;
	            int i = st.executeUpdate(sql);
	            System.out.println(sql);
	           

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
	}
	public static void deleteUser(UserDB x)
	{
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://"+ GlobalData.DatabaseHostName + ":3306/" + GlobalData.DatabaseName;
        String user = GlobalData.DatabaseUser;
        String password = GlobalData.DatabasePassword;
		  try {
	            con = (Connection) DriverManager.getConnection(url, user, password);
	            st = (Statement) con.createStatement();
	            String sql = "DELETE FROM users WHERE id = "+x.id;
	            int i = st.executeUpdate(sql);
	            System.out.println(sql);
	           

	        } catch (SQLException ex) {
	            Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);

	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	                if (con != null) {
	                    con.close();
	                }

	            } catch (SQLException ex) {
	                Logger lgr = Logger.getLogger(VersionFSHierarchyMaker.class.getName());
	                lgr.log(Level.WARNING, ex.getMessage(), ex);
	            }
	        }
	}
}
