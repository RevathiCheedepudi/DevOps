import java.sql.*;
import java.util.Scanner;
public class TransactionBatch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root", "Revathi");
            con.setAutoCommit(false);
            Statement st = con.createStatement();
            st.executeUpdate("drop table if exists students");
            st.executeUpdate("create table students(id int primary key,name varchar(50))");
            char ch;
             PreparedStatement ps=con.prepareStatement("insert into students values (?,?)");
            do{
            System.out.println("Enter student ID and Name");
            int id=sc.nextInt();
            String name=sc.next();
            ps.setInt(1,id);
            ps.setString(2, name);
            ps.addBatch();
            System.out.println("Do you want to enter one more record(y/n):");
            ch=sc.next().charAt(0);
            }
            while(ch=='y');
            try {
                ps.executeBatch();
                con.commit();
                System.out.println("Records inserted successfully!Transaction committed.");
            } catch (BatchUpdateException e) {
                con.rollback();
                System.out.println("Transaction rolled back.");
                e.printStackTrace();
            }
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
