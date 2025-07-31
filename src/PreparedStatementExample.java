import java.sql.PreparedStatement;
import java.sql.*;

public class PreparedStatementExample {
        public static void main(String[] a) throws SQLException, ClassNotFoundException {
            String url = "jdbc:mysql://192.168.71.15:3306/intern";
            String username = "intern2025";
            String password = "intern2025";
            String sql = "select * from users_shyam where user_name= ?and id=?";
            try {
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement pt_st = con.prepareStatement(sql);
                pt_st.setString(1,"virat");
                pt_st.setInt(2,101);
                ResultSet rs=pt_st.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString("user_name"));
                    System.out.println(rs.getString("user_email"));
                }
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
}