import java.sql.*;

public class ReusePrepareStatement {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        String sql = "insert into products_shyam (id,product_name,quantity,price) values (?,?,?,?)";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement prepared = con.prepareStatement(sql);
            prepared.setInt(1,105);
            prepared.setString(2,"remote");
            prepared.setInt(3,3);
            prepared.setDouble(4,1200);
            prepared.executeUpdate();
            prepared.setInt(1,106);
            prepared.setString(2,"bike");
            prepared.setInt(3,5);
            prepared.setDouble(4,12800);
            prepared.executeUpdate();
            prepared.setInt(1,107);
            prepared.setString(2,"car");
            prepared.setInt(3,6);
            prepared.setDouble(4,12000);
            prepared.executeUpdate();
            System.out.println("All items inserted");

            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
