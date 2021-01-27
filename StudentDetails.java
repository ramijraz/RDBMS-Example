package PreparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class StudentDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        Connection con = DBUtil.getConnection();
        PreparedStatement pst = null;
        String sql = "";

        int roll = 0;
        try {
            roll = Integer.parseInt(args[0]);
        } catch (Exception e) {}


        try {
            if (roll != 0)
                sql = "SELECT * FROM STUDENT WHERE roll = ?";
            else
                sql = "SELECT * FROM STUDENT";

            pst = con.prepareStatement(sql);
            if (roll != 0) pst.setInt(1, roll);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int ROLLNO = rs.getInt("ROLLNO");
                String STUDENTNAME = rs.getString("STUDENTNAME");
                String STANDARD = rs.getString("STANDARD");
                String DATE_OF_BIRTH = rs.getString("DATE_OF_BIRTH");
                double FEES = rs.getDouble("FEES");

                System.out.println(ROLLNO + " " + STUDENTNAME + " " + STANDARD +
                        " " + DATE_OF_BIRTH + " " + FEES);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sc.close();
	}

}
