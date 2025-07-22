import java.io.IOException;
import java.sql.*;

public class DeletingRecords {
    public static void main(String[] a) throws ClassNotFoundException, IOException {
        String sql = "delete from users_shyam where dob < '1983-12-12'";
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            con.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
