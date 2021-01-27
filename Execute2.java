package oracle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute2 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement st=null;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","ramij","ramij");
		}catch(Exception e) {
			System.out.println("Connection could not be established");
			if(con!=null) con.close();
		}
		 String sql = "SELECT * FROM emp WHERE sal > 1000 AND sal < 2000";
	        st = con.createStatement();
	        rs = st.executeQuery(sql);
	        
		 System.out.printf("%-10S%-10S%10S%10S\n", "ename", "job", "sal", "comm");
	        for (int i = 0; i < 50; i++) System.out.print("-");
	        System.out.println();

	        while (rs.next()) {
	            System.out.printf("%-10s%-10s%10s%10s\n",
	                rs.getString("ename"), rs.getString("job"), rs.getDouble("sal"), rs.getDouble("comm"));
	        }
		
		 if (st != null) st.close();
	        if (con != null) con.close();
	}

}
