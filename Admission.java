package PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admission {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		Connection con=DBUtil.getConnection();
		PreparedStatement pst=null;
		int roll=0;
		do {
		try {
		System.out.println("Enter RollNo : ");
		roll=Integer.parseInt(sc.next());
		if(String.valueOf(roll).length()!=4) roll=0;
		}catch(Exception e) {
			System.out.println("Please Enter a Four Digit Roll Number");
		}
	  }while(roll==0);
		
		String name="";
		boolean lower;
		do {
			System.out.println("Enter Student Name : ");
			name=sc.nextLine();
			
			lower=false;
			for(int i=0;i<name.length();i++) {
				if(Character.isLowerCase(name.charAt(i))) {
					lower=true;
					break;
				}
			}
		}while(name.length()>20 || lower);
		
		String standard="";
		String[] standards= {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
		List<String> list = new ArrayList<>(Arrays.asList(standards));
		do {
			System.out.println("Enter Standard : ");
			standard=sc.nextLine();
		}while(!list.contains(standard));
		
		System.out.println("Enter DOB : ");
		String dob=sc.nextLine();
		
		Double fees=0.0;
		do {
			System.out.println("Enter Fees : ");
			if(sc.hasNextDouble())
				fees=sc.nextDouble();
		}while(fees==0.0);
		
		String sql="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		try{
			pst=con.prepareStatement(sql);
			pst.setInt(1,roll);
			pst.setString(2, name);
			pst.setString(3, standard);
			pst.setString(4, dob);
			pst.setDouble(5, fees);
			pst.executeQuery();
			System.out.println("Student addes successfully");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error has been occured");
			pst.close();
			con.close();
		}
		sc.close();
	}
}





















