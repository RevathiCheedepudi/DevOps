import java.sql.*;
public class Count {
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","Revathi"); 
	       String NoOfRecords="select count(*) as record from emp";
               PreparedStatement ps=con.prepareStatement(NoOfRecords);
	      ResultSet rs=ps.executeQuery();
	      if(rs.next()){
		 int count = rs.getInt("record");
                System.out.println("Number of records in employee table: " +count);
}
	}	
		catch(Exception e) {
			e.printStackTrace();
		}
	}


}
