import java.sql.*;

public class NullHandling {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement=con.prepareStatement("insert into users_shyam (id,user_name,user_email,dob,phone_no) values(?,?,?,?,?)");
            preparedStatement.setInt(1,104);
            preparedStatement.setString(2,"sai sudarshan");
            preparedStatement.setString(3,"sai5@gmail.com");
            preparedStatement.setNull(4,java.sql.Types.VARCHAR);
            preparedStatement.setString(5,"9581673142");
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
