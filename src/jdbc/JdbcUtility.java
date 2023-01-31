/**
 * 
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author: Boqiang Cui
 * @date: Jan 30, 2023
 */
public class JdbcUtility {
	private Connection con;
	
	public JdbcUtility(String DBname, String userName, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBname, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
