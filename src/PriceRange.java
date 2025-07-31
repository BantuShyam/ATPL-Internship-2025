import java.sql.*;

public class PriceRange {
    public static void main(String[] a) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://192.168.71.15:3306/intern";
        String username = "intern2025";
        String password = "intern2025";
        String sql = "select product_name from products_shyam where price between ? and ?";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pt_st = con.prepareStatement(sql);
            pt_st.setDouble(1,1500);
            pt_st.setDouble(2,2000);
            ResultSet rs=pt_st.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
