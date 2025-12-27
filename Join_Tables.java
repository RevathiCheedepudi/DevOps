import java.sql.*;
public class Join_Tables {
   public static void main(String[] args) {
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC","root","Revathi"); 
       Statement st=con.createStatement();
       st.addBatch("drop table if exists students");
       st.addBatch("drop table if exists marks");
       st.executeBatch();
       st.addBatch("create table students(id int primary key,name varchar(50))");
       st.addBatch("create table marks(id int,subject varchar(50),marks int)");
       st.executeBatch();
       st.addBatch("insert into students values (1,'Revathi'),(2,'Hari'),(3,'Priya'),(4,'Surya'),(5,'Sanjana')");
       st.addBatch("insert into marks values (1, 'Math', 95),(1, 'Science', 90),(2, 'Math', 78),(2, 'Science', 88), (3, 'Math', 92),(6, 'Math', 70),(4, 'Science', 81)");
       st.executeBatch();
       String joinQuery="select stu.name,Sum(mar.marks) from students stu inner join marks mar on stu.id=mar.id group by stu.name";
       ResultSet rs=st.executeQuery(joinQuery);
       while(rs.next()){
        System.out.println("Name:"+rs.getString(1)+"  Total marks:"+rs.getInt(2));
       }
     con.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
   }
}
