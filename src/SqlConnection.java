import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


public class SqlConnection {
    public static void main(String[] a) throws SQLException, ClassNotFoundException, IOException {
        String sql = "select * from student_shyam";
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("student_id") + " " + rs.getString("student_name"));
            }
            con.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
