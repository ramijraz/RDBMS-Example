package PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static Connection getConnection() {
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","ramij","ramij");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
