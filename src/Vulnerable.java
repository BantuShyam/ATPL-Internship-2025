import java.sql.*;

public class Vulnerable {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        //Class.forName("com.mysql.jdbc.Driver");
        String user ="virat";
        int id=101;
        String sql = "select * from users_shyam where user_name='"+user+"'and id="+id;
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("user_name"));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
