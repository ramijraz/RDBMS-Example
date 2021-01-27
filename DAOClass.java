package PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public class DAOClass {
	private Connection con=null;
	PreparedStatement pst=null;
	
	public DAOClass() {
	con=DBUtil.getConnection();	
	}
	
	public boolean insert (int rollno,String name,String grade,String dob,int fee) {
			String sql="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		
			try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, rollno);
			pst.setString(2,name);
			pst.setString(3, grade);
			pst.setString(4, dob);
			pst.setInt(5, fee);
			return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}	
	 }
	
	public boolean delete(int rollno) {
		String sql="DELETE STUDENT WHERE ROLLNO=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, rollno);
			pst.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean modify(int rollno,int fee) {
		String sql="UPDATE STUDENT SET FEE=? WHERE ROLLNO=?";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, fee);
			pst.setInt(2, rollno);
			pst.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean display(int rollno) {
		String sql="SELECT * FROM STUDENT WHERE ROLLNO=?";
		
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, rollno);
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()) {
				StringBuilder sb=new StringBuilder();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					String colname=rsmd.getColumnName(i);
					sb.append(rs.getObject(colname));
					 if (i != rsmd.getColumnCount()) sb.append(", ");
				}
				System.out.println(sb);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean display() {
		String sql="SELECT * FROM STUDENT";
		try {
			pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()) {
				StringBuilder sb=new StringBuilder();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					String colname=rsmd.getColumnName(i);
					sb.append(rs.getObject(colname));
					 if (i != rsmd.getColumnCount()) sb.append(", ");
				}
				System.out.println(sb);
			}
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}












