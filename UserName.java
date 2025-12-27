import java.sql.*;
import java.util.*;
public class UserName {
   public static void main(String[] args) {
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","Revathi"); 
       Scanner sc=new Scanner(System.in);
       PreparedStatement ps=con.prepareStatement("select * from users where username=? and password=?");
       System.out.println("Enter user name and password");
       String username=sc.next();
       String password=sc.next();
       ps.setString(1, username);
       ps.setString(2, password);
       ResultSet rs=ps.executeQuery();
       if(rs.next()){
        System.out.println(username+" Login is Successful");
       }
       else{
        System.out.println("Invalid username or password");
       }
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
}
