package PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class DeleteQuary {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		String sql="";
		
		int roll=Integer.parseInt(args[0]);
		try {
			sql="INSERT INTO STUDENT_LOG SELECT * FROM STUDENT WHERE ROLL=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,roll);
			int logged=pst.executeUpdate();
			
			sql="DELETE FROM STUDENT WHERE ROLL=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, roll);
			
			if(pst.executeUpdate()==1&& logged==1)
				System.out.println("Roll no "+roll+" deleted successfully");
			else
				System.out.println("Deletion error");
		}catch(Exception e) {
			e.printStackTrace();
			pst.close();
		}
		sc.close();
		
	}

}
