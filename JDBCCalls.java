package PreparedStatement;

public class JDBCCalls {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op=Integer.parseInt(args[0]);
		DAOClass da=new DAOClass();
		
		switch(op) {
		
		case 1:
			int rollno=Integer.parseInt(args[1]);
			String name=args[2];
			String grade=args[3];
			String dob=args[4];
			int fee=Integer.parseInt(args[5]);
			
			if(da.insert(rollno, name, grade, dob, fee)) 
				System.out.println("Inserted Successfully");
			else 
				System.out.println("Insertation error");
			break;
			
		case 2:
			rollno=Integer.parseInt(args[1]);
			
			if(da.delete(rollno))
				System.out.println("Deleted Successfully");
			else
				System.out.println("Deletion error");
			break;
			
		case 3:
			rollno=Integer.parseInt(args[1]);
			fee=Integer.parseInt(args[2]);
			
			if(da.modify(rollno, fee))
				System.out.println("Modified Successfully");
			else 
				System.out.println("Modificaion error");
			break;
			
		case 4:
			  try {
	                rollno = Integer.parseInt(args[1]);
	                da.display(rollno);
	                break;
	            } catch (Exception e) {
	                da.display();
	                break;
	            }
			 }
	}

}
















