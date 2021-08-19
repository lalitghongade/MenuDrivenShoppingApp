package dbConnection;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDBConnection {
	
private static Connection connection;
	
	MySQLDBConnection(){}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/revature_practice";
        String username="lala";
        String password ="lala";
        
        
        connection = DriverManager.getConnection(url, username, password);
        
        return connection;
	}

}
