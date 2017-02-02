/**
 * 
 */
package de.ehrenchris.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * @author christian.boehme
 *
 */
public class DBHelper {

	private static BasicDataSource connectionPool;
	
	public static Connection getConnection(){
		try{

			URI dbUri = new URI(System.getenv("DATABASE_URL"));
			String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
			connectionPool=new BasicDataSource();

			if(dbUri.getUserInfo()!=null)
			{
				connectionPool.setUsername(dbUri.getUserInfo().split(":")[0]);
				connectionPool.setPassword(dbUri.getUserInfo().split(":")[1]);
			}connectionPool.setDriverClassName("org.postgresql.Driver");connectionPool.setUrl(dbUrl);connectionPool.setInitialSize(1);

			Connection connection = connectionPool.getConnection();
			/*
			Statement stmt = connection.createStatement();stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");while(rs.next())
			{
				System.out.println("Read from DB: " + rs.getTimestamp("tick") + "\n");
			}
			*/
			
			return connection;
			
		} catch (URISyntaxException | SQLException e){
			return null;
		}
	}
	
}
