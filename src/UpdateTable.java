import java.sql.Connection;
import java.sql.*;

public class UpdateTable {
    public static void main(String[] a) throws SQLException {
        String sql = "update users_shyam set user_email='viratanu@gmail.com' where id=101";
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://192.168.71.15:3306/intern", "intern2025", "intern2025");
            Statement st = con.createStatement();
            st.executeUpdate(sql);
        } finally {
            con.close();
        }
    }
}