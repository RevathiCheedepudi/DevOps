import java.sql.*;
import java.util.*;
public class Options_Table {
	public static void insert(Connection con,int num,String name,String address) {
		try {
			PreparedStatement ps=con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1, num);
			ps.setString(2,name);
			ps.setString(3, address);
			ps.execute();
			System.out.println("Inserted Successfully");
		}
		catch(Exception e) {
            e.printStackTrace();
        }
	}
	public static void update(Connection con,int num,String address) {
		try {
			PreparedStatement ps=con.prepareStatement("update emp set address=? where num=?");
			ps.setString(1,address);
			ps.setInt(2, num);
			ps.execute();
			System.out.println("Updated Successfully");
		}
		catch(Exception e) {
           e.printStackTrace();
        }
	}
	public static void retrieve(Connection con) {
		try {
		PreparedStatement ps=con.prepareStatement("select * from emp");
                ResultSet rs=ps.executeQuery();
                 while(rs.next()) {
                 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
               }
		}
		catch(Exception e) {
            e.printStackTrace();
        }
	}
       public static void delete(Connection con,int num) {
		try {
		PreparedStatement ps=con.prepareStatement("delete from emp where num=?");
		ps.setInt(1,num);
		ps.executeUpdate();
		}
		catch(Exception e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","Revathi"); 
		Scanner sc=new Scanner(System.in);
		char ch;
	    do{
		System.out.println("Enter the option: \n1.Insert into table \n2.Upate the data \n3.Retrieve the data \n4.Delete the data");
		int choice=sc.nextInt();
		if(choice==1) {
			System.out.println("Enter employee number,name and address");
			int num=sc.nextInt();
			String name=sc.next();
			String address=sc.next();
			insert(con,num,name,address);
		}
		else if(choice==2) {
			System.out.println("Enter employee number and address");
			int num=sc.nextInt();
			String address=sc.next();
			update(con,num,address);
		}
		else if(choice==3) {
			retrieve(con);	
        }
		else if(choice==4) {
			System.out.println("Enter employee number you want to delete");
 			int num=sc.nextInt();
			delete(con,num);
        }
		else {
			System.out.println("Enter the correct option");
		}
		System.out.println("Do you want to enter another option(y/n):");
		ch=sc.next().charAt(0);	
	}
		while(ch=='y');
		System.out.println("Thank You!!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}



