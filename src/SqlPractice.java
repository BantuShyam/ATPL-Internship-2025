import java.sql.*;

public class SqlPractice {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String sql="select * from student;";
        String url="jdbc:mysql://localhost:3306/Studentdb";
        String username="root";
        String password="shyam@1773";
//        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,username,password);
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }
        con.close();
    }
}
