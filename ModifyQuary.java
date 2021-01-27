package PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ModifyQuary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		String sql="";
		
		int roll=Integer.parseInt(args[0]);
		double fees=Double.parseDouble(args[1]);
		
		try {
			sql="UPDATE STUDENT SET FEES=? WHERE ROLL=?";
			pst=con.prepareStatement(sql);
			pst.setDouble(1,fees);
			pst.setInt(2, roll);
			
			if(pst.executeUpdate()==1)
				System.out.println("Fees of the student updated successfully");
			else 
				System.out.println("Update error");
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

}
