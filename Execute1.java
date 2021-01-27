package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Execute1 {

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
		}
		
		String sql="SELECT EMPNO,ENAME FROM EMP";
		st=con.createStatement();
		rs=st.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("Emp_id : "+rs.getInt(1)+" Emp_name : "+rs.getString("ENAME"));
		}
		if (st != null) st.close();
        if (con != null) con.close();
	}

}
