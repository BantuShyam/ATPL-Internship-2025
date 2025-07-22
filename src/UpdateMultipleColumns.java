import java.io.IOException;
import java.sql.*;

public class UpdateMultipleColumns {
    public static void main(String[] a) throws SQLException, ClassNotFoundException, IOException {
        String sql = "update users_shyam set phone_no='9481563151' , user_email='rohitika@gmail.com' where id=102";
        String select_sql="select user_name,phone_no,user_email from users_shyam where id=102";
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
       // Class.forName("com.mysql.jdbc.Driver");
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            ResultSet rs=st.executeQuery(select_sql);
            while (rs.next()) {
                System.out.println("Name "+rs.getString("user_name"));
                System.out.println("Updated phone no "+rs.getString("phone_no"));
                System.out.println("Updated email "+rs.getString("user_email"));
            }
            con.close();
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
