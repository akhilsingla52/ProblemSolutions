import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
	static Connection connection = null;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chaperone", "root", "root");
		} catch( Exception e) {
			System.out.println("Exception : ");
			e.printStackTrace();
		}
	}
	
	public static void main(String... s) {
		executePreparedStatement();
	}
	
	public static void executePreparedStatement() {
		try {
			/*PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin_user");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				println("Id : " + rs.getString(1));
				println("email : " + rs.getString(3));
				println("password : " + rs.getString(5));
			}*/
			
			PreparedStatement statement = connection.prepareStatement("Update admin_user set password='chaperone' WHERE email=?");
			statement.setString(1, "akhil.singla@atmecs.com");
			
			int i=statement.executeUpdate();  
			println(i+" records updated"); 
			
		} catch( SQLException se ) {
			println("SQL Exception : ");
			se.printStackTrace();
		} catch( Exception e) {
			println("Exception : ");
			e.printStackTrace();
		} finally {
			try {
				if( connection != null )
					connection.close();
			} catch( Exception e) {
				System.out.println("Exception : ");
				e.printStackTrace();
			} 
		}
	}
	
	public static void executeStatement() {
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM admin_user");
			
			while(rs.next()) {
				println("Id : " + rs.getString(1));
				println("email : " + rs.getString(3));
				println("password : " + rs.getString(5));
			}
		} catch( SQLException se ) {
			println("SQL Exception : ");
			se.printStackTrace();
		} catch( Exception e) {
			println("Exception : ");
			e.printStackTrace();
		} finally {
			try {
				if( connection != null )
					connection.close();
			} catch( Exception e) {
				System.out.println("Exception : ");
				e.printStackTrace();
			} 
		}
	}
	
	public static void println(String message) {
		System.out.println(message);
	}
}